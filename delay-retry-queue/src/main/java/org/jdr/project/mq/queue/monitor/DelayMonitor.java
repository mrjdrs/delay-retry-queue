package org.jdr.project.mq.queue.monitor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdr.project.mq.queue.consume.DelayConsume;
import org.jdr.project.mq.queue.definition.DelayConsumeException;
import org.jdr.project.mq.queue.definition.DelayTime;
import org.jdr.project.mq.queue.definition.ExceptionRetryStrategy;
import org.jdr.project.mq.queue.definition.MessageHeader;
import org.jdr.project.mq.queue.definition.queue.QueueConstant;
import org.jdr.project.mq.queue.delay.DelayQueue;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhoude
 * @date 2021/1/29 13:57
 */
@Component
@Slf4j
@AllArgsConstructor
public class DelayMonitor implements InitializingBean {

    private final ApplicationContext applicationContext;
    private final DelayQueue delayQueue;

    private Map<String, DelayConsume<?>> consumeMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, DelayConsume> beansOfType = applicationContext.getBeansOfType(DelayConsume.class);
        consumeMap = new HashMap<>(beansOfType.size());
        for (DelayConsume consume : beansOfType.values()) {
            consumeMap.put(consume.consumerKey(), consume);
        }
    }

    private void handler(Message message) {
        String json = new String(message.getBody());
        String consumerKey = message.getMessageProperties().getHeader(MessageHeader.HEADER_CONSUMER);
        MessageProperties properties = message.getMessageProperties();

        try {
            consumeMap.get(consumerKey).handleNoType(json);
        }
        catch (DelayConsumeException e) {
            ExceptionRetryStrategy strategy = ExceptionRetryStrategy.valueOf(properties.getHeader(MessageHeader.EXCEPTION_STRATEGY));
            DelayTime delayTime = DelayTime.valueOf(properties.getHeader(MessageHeader.DELAY_TIME));
            switch (strategy) {
                case NOTIFY:
                    log.info("已发送邮件通知相关人员");
                    break;
                case RETRY:
                    delayQueue.send(json, delayTime, ExceptionRetryStrategy.RETRY, consumerKey);
                    break;
                case FIVE_NOTIFY:
                case CUSTOMIZE:
                    retry(ExceptionRetryStrategy.valueOf(strategy.name()).getRetryCount(), message);
                    break;
                default:
                    throw new IllegalStateException("无效的重试策略");
            }
        }
        catch (Exception e) {
            log.error("消费异常", e);
        }
    }

    private void retry(int count, Message message) {
        String json = new String(message.getBody());
        MessageProperties properties = message.getMessageProperties();
        ExceptionRetryStrategy strategy = ExceptionRetryStrategy.valueOf(properties.getHeader(MessageHeader.EXCEPTION_STRATEGY));

        AtomicInteger retryTime;
        if (properties.getHeaders().containsKey(MessageHeader.RETRY_TIME)) {
            Object invokeCount = properties.getHeaders().get(MessageHeader.RETRY_TIME);
            retryTime = new AtomicInteger(Integer.parseInt(invokeCount.toString()));
        }
        else {
            retryTime = new AtomicInteger(0);
        }

        if (retryTime.get() < count) {
            DelayTime delayTime = DelayTime.valueOf(properties.getHeader(MessageHeader.DELAY_TIME));
            properties.setHeader(MessageHeader.RETRY_TIME, retryTime.incrementAndGet());
            delayQueue.sendWithHeader(json, delayTime, message.getMessageProperties().getHeaders());
        }
        else {
            // 发邮件通知
            log.info("已发送邮件通知相关人员");
        }
    }

    @RabbitListener(queues = QueueConstant.FIVE_SECONDS_DEAD_QUEUE)
    public void fiveSeconds(Message message) {
        handler(message);
    }

    @RabbitListener(queues = QueueConstant.ONE_MINUTES_DEAD_QUEUE)
    public void oneMinutes(Message message) {
        handler(message);
    }

    @RabbitListener(queues = QueueConstant.THIRTY_MINUTES_DEAD_QUEUE)
    public void thirtyMinutes(Message message) {
        handler(message);
    }

    @RabbitListener(queues = QueueConstant.ONE_HOURS_DEAD_QUEUE)
    public void oneHours(Message message) {
        handler(message);
    }

}