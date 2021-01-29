package org.jdr.project.mq.queue.definition;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常重试策略
 *
 * @author zhoude
 * @date 2021/1/29 14:26
 */
@Getter
@AllArgsConstructor
public enum ExceptionRetryStrategy {

    /**
     * 直接通知
     */
    NOTIFY(1),

    /**
     * 五次后通知
     */
    FIVE_NOTIFY(5),

    /**
     * 一直重试
     */
    RETRY(Integer.MAX_VALUE),

    /**
     * 自定义，默认3次
     */
    CUSTOMIZE(3) {
        @Override
        public ExceptionRetryStrategy resetRetryCount(int retryCount) {
            synchronized (ExceptionRetryStrategy.class) {
                ExceptionRetryStrategy.CUSTOMIZE.retryCount = retryCount;
            }
            return this;
        }
    },
    ;

    /**
     * 重试次数
     */
    private int retryCount;

    /**
     * 重新设置重试次数
     */
    public ExceptionRetryStrategy resetRetryCount(int retryCount) {
        throw new UnsupportedOperationException("不支持此操作，应由子类实现");
    }

}