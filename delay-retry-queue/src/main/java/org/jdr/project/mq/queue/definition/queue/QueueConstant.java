package org.jdr.project.mq.queue.definition.queue;

/**
 * mq队列常量
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
public interface QueueConstant {

    /**
     * 延迟五秒队列
     */
    String FIVE_SECONDS_QUEUE = "five.seconds.queue";

    /**
     * 延迟五秒死信队列
     */
    String FIVE_SECONDS_DEAD_QUEUE = "five.seconds.dead.queue";

    /**
     * 延迟一分钟队列
     */
    String ONE_MINUTES_QUEUE = "one.minutes.queue";

    /**
     * 延迟一分钟死信队列
     */
    String ONE_MINUTES_DEAD_QUEUE = "one.minutes.dead.queue";

    /**
     * 延迟三十分钟队列
     */
    String THIRTY_MINUTES_QUEUE = "thirty.minutes.queue";

    /**
     * 延迟三十分钟死信队列
     */
    String THIRTY_MINUTES_DEAD_QUEUE = "thirty.minutes.dead.queue";

    /**
     * 延迟一小时秒队列
     */
    String ONE_HOURS_QUEUE = "one.hours.queue";

    /**
     * 延迟一小时死信队列
     */
    String ONE_HOURS_DEAD_QUEUE = "one.hours.dead.queue";

}
