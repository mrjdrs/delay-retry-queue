package org.jdr.project.mq.queue.definition.exchange;

/**
 * mq交换器常量
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
public interface ExchangeConstant {

    /**
     * 延迟五秒交换机
     */
    String FIVE_SECONDS_EXCHANGE = "five.seconds.exchange";

    /**
     * 延迟五秒死信交换机
     */
    String FIVE_SECONDS_DEAD_EXCHANGE = "five.seconds.dead.exchange";

    /**
     * 延迟一分钟交换机
     */
    String ONE_MINUTES_EXCHANGE = "one.minutes.exchange";

    /**
     * 延迟一分钟死信交换机
     */
    String ONE_MINUTES_DEAD_EXCHANGE = "one.minutes.dead.exchange";

    /**
     * 延迟三十分钟交换机
     */
    String THIRTY_MINUTES_EXCHANGE = "thirty.minutes.exchange";

    /**
     * 延迟三十分钟死信交换机
     */
    String THIRTY_MINUTES_DEAD_EXCHANGE = "thirty.minutes.dead.exchange";

    /**
     * 延迟一小时秒交换机
     */
    String ONE_HOURS_EXCHANGE = "one.hours.exchange";

    /**
     * 延迟一小时死信交换机
     */
    String ONE_HOURS_DEAD_EXCHANGE = "one.hours.dead.exchange";

}