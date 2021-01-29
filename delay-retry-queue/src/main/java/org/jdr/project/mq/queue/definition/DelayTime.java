package org.jdr.project.mq.queue.definition;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * 延迟时间枚举
 *
 * @author zhoude
 * @date 2021/1/29 13:23
 */
@Getter
@AllArgsConstructor
public enum DelayTime {

    /**
     * 延迟五秒执行
     */
    FIVE_SECONDS(5L, TimeUnit.SECONDS),

    /**
     * 延迟一分钟执行
     */
    ONE_MINUTES(1L, TimeUnit.MINUTES),

    /**
     * 延迟三十分钟执行
     */
    THIRTY_MINUTES(30L, TimeUnit.MINUTES),

    /**
     * 延迟一小时执行
     */
    ONE_HOURS(1L, TimeUnit.HOURS),
    ;

    /**
     * 延迟时间
     */
    private final long delayTime;

    /**
     * 延迟时间单位
     */
    private final TimeUnit delayUnit;

    /**
     * 将定义的单位时间转换成毫秒
     *
     * @return 已毫秒显示的延迟时间
     */
    public long toMillisecond() {
        return this.delayUnit.toMillis(this.delayTime);
    }

}