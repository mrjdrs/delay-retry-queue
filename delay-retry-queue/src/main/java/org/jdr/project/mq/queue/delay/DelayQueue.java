package org.jdr.project.mq.queue.delay;

import org.jdr.project.mq.queue.definition.DelayTime;
import org.jdr.project.mq.queue.definition.ExceptionRetryStrategy;

import java.util.Map;

/**
 * 延迟队列定义
 *
 * @author zhoude
 * @date 2021/1/29 13:54
 */
public interface DelayQueue {

    /**
     * 发送延迟队列
     *
     * @param json                   发送消息
     * @param delayTime              延迟定义
     * @param exceptionRetryStrategy 重试策略
     * @param consumeKey             消费者key
     */
    void send(String json, DelayTime delayTime, ExceptionRetryStrategy exceptionRetryStrategy, String consumeKey);

    /**
     * 发送延迟队列（包含header）
     *
     * @param json      发送消息
     * @param delayTime 延迟定义
     * @param header    消息头
     */
    void sendWithHeader(String json, DelayTime delayTime, Map<String, Object> header);

}