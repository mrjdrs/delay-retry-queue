package org.jdr.project.mq.queue.definition.exchange;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * mq交换器配置类
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
@Component
@Configuration
public class ExchangeConfig {

    @Bean(name = "fiveSecondsExchange")
    public TopicExchange initFiveSecondsExchange() {
        return new TopicExchange(ExchangeConstant.FIVE_SECONDS_EXCHANGE);
    }

    @Bean(name = "fiveSecondsDeadExchange")
    public FanoutExchange initFiveSecondsDeadExchange() {
        return new FanoutExchange(ExchangeConstant.FIVE_SECONDS_DEAD_EXCHANGE);
    }

    @Bean(name = "oneMinutesExchange")
    public TopicExchange initOneMinutesExchange() {
        return new TopicExchange(ExchangeConstant.ONE_MINUTES_EXCHANGE);
    }

    @Bean(name = "oneMinutesDeadExchange")
    public FanoutExchange initOneMinutesDeadExchange() {
        return new FanoutExchange(ExchangeConstant.ONE_MINUTES_DEAD_EXCHANGE);
    }

    @Bean(name = "thirtyMinutesExchange")
    public TopicExchange initThirtyMinutesExchange() {
        return new TopicExchange(ExchangeConstant.THIRTY_MINUTES_EXCHANGE);
    }

    @Bean(name = "thirtyMinutesDeadExchange")
    public FanoutExchange initThirtyMinutesDeadExchange() {
        return new FanoutExchange(ExchangeConstant.THIRTY_MINUTES_DEAD_EXCHANGE);
    }

    @Bean(name = "oneHoursExchange")
    public TopicExchange initOneHoursExchange() {
        return new TopicExchange(ExchangeConstant.ONE_HOURS_EXCHANGE);
    }

    @Bean(name = "oneHoursDeadExchange")
    public FanoutExchange initOneHoursDeadExchange() {
        return new FanoutExchange(ExchangeConstant.ONE_HOURS_DEAD_EXCHANGE);
    }

}