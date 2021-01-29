package org.jdr.project.mq.queue.definition.queue;

import org.jdr.project.mq.queue.definition.DelayTime;
import org.jdr.project.mq.queue.definition.exchange.ExchangeConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * mq队列配置类
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
@Component
@Configuration
public class QueueConfig {

    @Bean(name = "fiveSecondsQueue")
    public Queue initFiveSecondsQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-message-ttl", DelayTime.FIVE_SECONDS.toMillisecond());
        arguments.put("x-dead-letter-exchange", ExchangeConstant.FIVE_SECONDS_DEAD_EXCHANGE);
        return new Queue(QueueConstant.FIVE_SECONDS_QUEUE, true, false, false, arguments);
    }

    @Bean(name = "fiveSecondsDeadQueue")
    public Queue initFiveSecondsDeadQueue() {
        return new Queue(QueueConstant.FIVE_SECONDS_DEAD_QUEUE);
    }

    @Bean(name = "oneMinutesQueue")
    public Queue initOneMinutesQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-message-ttl", DelayTime.ONE_MINUTES.toMillisecond());
        arguments.put("x-dead-letter-exchange", ExchangeConstant.ONE_MINUTES_DEAD_EXCHANGE);
        return new Queue(QueueConstant.ONE_MINUTES_QUEUE, true, false, false, arguments);
    }

    @Bean(name = "oneMinutesDeadQueue")
    public Queue initOneMinutesDeadQueue() {
        return new Queue(QueueConstant.ONE_MINUTES_DEAD_QUEUE);
    }

    @Bean(name = "thirtyMinutesQueue")
    public Queue initThirtyMinutesQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-message-ttl", DelayTime.THIRTY_MINUTES.toMillisecond());
        arguments.put("x-dead-letter-exchange", ExchangeConstant.THIRTY_MINUTES_DEAD_EXCHANGE);
        return new Queue(QueueConstant.THIRTY_MINUTES_QUEUE, true, false, false, arguments);
    }

    @Bean(name = "thirtyMinutesDeadQueue")
    public Queue initThirtyMinutesDeadQueue() {
        return new Queue(QueueConstant.THIRTY_MINUTES_DEAD_QUEUE);
    }

    @Bean(name = "oneHoursQueue")
    public Queue initOneHoursQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-message-ttl", DelayTime.ONE_HOURS.toMillisecond());
        arguments.put("x-dead-letter-exchange", ExchangeConstant.ONE_HOURS_DEAD_EXCHANGE);
        return new Queue(QueueConstant.ONE_HOURS_QUEUE, true, false, false, arguments);
    }

    @Bean(name = "oneHoursDeadQueue")
    public Queue initOneHoursDeadQueue() {
        return new Queue(QueueConstant.ONE_HOURS_DEAD_QUEUE);
    }

}
