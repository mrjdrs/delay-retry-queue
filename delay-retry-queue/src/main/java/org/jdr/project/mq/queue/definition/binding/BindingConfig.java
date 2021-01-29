package org.jdr.project.mq.queue.definition.binding;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * mq绑定器配置类
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
@Component
@Configuration
public class BindingConfig {

    @Bean(name = "fiveSecondsBinding")
    public Binding initFiveSecondsBinding(@Qualifier("fiveSecondsQueue") Queue queue,
                                          @Qualifier("fiveSecondsExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BindingConstant.FIVE_SECONDS_ROUTING_KEY);
    }

    @Bean(name = "fiveSecondsDeadBinding")
    public Binding initFiveSecondsDeadBinding(@Qualifier("fiveSecondsDeadQueue") Queue queue,
                                              @Qualifier("fiveSecondsDeadExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean(name = "oneMinutesBinding")
    public Binding initOneMinutesBinding(@Qualifier("oneMinutesQueue") Queue queue,
                                         @Qualifier("oneMinutesExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BindingConstant.ONE_MINUTES_ROUTING_KEY);
    }

    @Bean(name = "oneMinutesDeadBinding")
    public Binding initOneMinutesDeadBinding(@Qualifier("oneMinutesDeadQueue") Queue queue,
                                             @Qualifier("oneMinutesDeadExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean(name = "thirtyMinutesBinding")
    public Binding initThirtyMinutesBinding(@Qualifier("thirtyMinutesQueue") Queue queue,
                                            @Qualifier("thirtyMinutesExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BindingConstant.THIRTY_MINUTES_ROUTING_KEY);
    }

    @Bean(name = "thirtyMinutesDeadBinding")
    public Binding initThirtyMinutesDeadBinding(@Qualifier("thirtyMinutesDeadQueue") Queue queue,
                                                @Qualifier("thirtyMinutesDeadExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean(name = "oneHoursBinding")
    public Binding initOneHoursBinding(@Qualifier("oneHoursQueue") Queue queue,
                                       @Qualifier("oneHoursExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BindingConstant.ONE_HOURS_ROUTING_KEY);
    }

    @Bean(name = "oneHoursDeadBinding")
    public Binding initOneHoursDeadBinding(@Qualifier("oneHoursDeadQueue") Queue queue,
                                           @Qualifier("oneHoursDeadExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}