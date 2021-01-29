package org.jdr.project.mq.queue.definition;

/**
 * 消息头
 *
 * @author zhoude
 * @date 2021/1/29 16:22
 */
public interface MessageHeader {

    /**
     * 消费者的key
     */
    String HEADER_CONSUMER = "consumer-key";

    /**
     * 延迟时间
     */
    String DELAY_TIME = "delay-time";

    /**
     * 异常策略
     */
    String EXCEPTION_STRATEGY = "exception-strategy";

    /**
     * 重试次数
     */
    String RETRY_TIME = "retry-time";

}