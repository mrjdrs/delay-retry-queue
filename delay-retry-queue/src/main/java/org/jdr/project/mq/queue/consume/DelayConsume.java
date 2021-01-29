package org.jdr.project.mq.queue.consume;

import org.jdr.project.mq.queue.definition.DelayConsumeException;

/**
 * @author zhoude
 * @date 2021/1/29 13:57
 */
public interface DelayConsume<T> {

    /**
     * 获取消费的队列key
     *
     * @return 队列key
     */
    String consumerKey();

    /**
     * 消费消息
     *
     * @param payLoad 消息数据
     */
    void handle(T payLoad);

    @SuppressWarnings("unchecked")
    default void handleNoType(Object payLoad) throws DelayConsumeException {
        handle((T) payLoad);
    }

}