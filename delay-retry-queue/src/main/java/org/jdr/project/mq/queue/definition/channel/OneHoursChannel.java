package org.jdr.project.mq.queue.definition.channel;

import org.jdr.project.mq.queue.definition.binding.BindingConstant;
import org.jdr.project.mq.queue.definition.exchange.ExchangeConstant;
import org.springframework.stereotype.Component;

/**
 * @author zhoude
 * @date 2021/1/29 15:17
 */
@Component
public class OneHoursChannel implements MessageChannel {

    @Override
    public String getExchangeKey() {
        return ExchangeConstant.ONE_HOURS_EXCHANGE;
    }

    @Override
    public String getBindingKey() {
        return BindingConstant.ONE_HOURS_ROUTING_KEY;
    }

}