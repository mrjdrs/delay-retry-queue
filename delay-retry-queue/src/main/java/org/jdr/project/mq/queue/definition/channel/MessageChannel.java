package org.jdr.project.mq.queue.definition.channel;

/**
 * @author zhoude
 * @date 2021/1/29 15:16
 */
public interface MessageChannel {

    /**
     * 获取交换机key
     *
     * @return 交换机key
     */
    String getExchangeKey();

    /**
     * 获取路由key
     *
     * @return 路由key
     */
    String getBindingKey();

}