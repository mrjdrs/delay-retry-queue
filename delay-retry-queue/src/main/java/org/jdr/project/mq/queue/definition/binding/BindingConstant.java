package org.jdr.project.mq.queue.definition.binding;

/**
 * mq绑定器常量
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
public interface BindingConstant {

    /**
     * 五秒延迟绑定器
     */
    String FIVE_SECONDS_ROUTING_KEY = "five.seconds.routing.key";

    /**
     * 一分钟延迟绑定器
     */
    String ONE_MINUTES_ROUTING_KEY = "one.minutes.routing.key";

    /**
     * 三十分钟延迟绑定器
     */
    String THIRTY_MINUTES_ROUTING_KEY = "thirty.minutes.routing.key";

    /**
     * 一小时延迟绑定器
     */
    String ONE_HOURS_ROUTING_KEY = "one.hours.routing.key";

}