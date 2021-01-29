package org.jdr.project.mq.queue.delay;

import lombok.AllArgsConstructor;
import org.jdr.project.mq.queue.definition.DelayTime;
import org.jdr.project.mq.queue.definition.ExceptionRetryStrategy;
import org.jdr.project.mq.queue.definition.MessageHeader;
import org.jdr.project.mq.queue.definition.channel.FiveSecondsChannel;
import org.jdr.project.mq.queue.definition.channel.MessageChannel;
import org.jdr.project.mq.queue.definition.channel.OneHoursChannel;
import org.jdr.project.mq.queue.definition.channel.ThirtyMinutesChannel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送延迟队列的默认实现
 *
 * @author zhoude
 * @date 2021/1/29 13:55
 */
@Component
@AllArgsConstructor
public class DelayQueueDefaultImpl implements DelayQueue, InitializingBean {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationContext applicationContext;

    private Map<DelayTime, MessageChannel> delayMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        delayMap = new HashMap<>(DelayTime.values().length);
        delayMap.put(DelayTime.FIVE_SECONDS, applicationContext.getBean(FiveSecondsChannel.class));
        delayMap.put(DelayTime.ONE_MINUTES, applicationContext.getBean(OneHoursChannel.class));
        delayMap.put(DelayTime.THIRTY_MINUTES, applicationContext.getBean(ThirtyMinutesChannel.class));
        delayMap.put(DelayTime.ONE_HOURS, applicationContext.getBean(OneHoursChannel.class));
    }

    @Override
    public void send(String json, DelayTime delayTime, ExceptionRetryStrategy exceptionRetryStrategy, String consumeKey) {
        HashMap<String, Object> header = new HashMap<>(16);
        header.put(MessageHeader.HEADER_CONSUMER, consumeKey);
        header.put(MessageHeader.EXCEPTION_STRATEGY, exceptionRetryStrategy.name());
        header.put(MessageHeader.DELAY_TIME, delayTime.name());
        sendWithHeader(json, delayTime, header);
    }

    @Override
    public void sendWithHeader(String json, DelayTime delayTime, Map<String, Object> header) {
        MessageChannel messageChannel = delayMap.get(delayTime);
        Message message = MessageBuilder.withBody(json.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8").build();
        for (String key : header.keySet()) {
            message.getMessageProperties().setHeader(key, header.get(key));
        }
        rabbitTemplate.convertAndSend(messageChannel.getExchangeKey(), messageChannel.getBindingKey(), message);
    }

}