package org.jdr.project.mq.queue.definition;

import org.jdr.project.mq.queue.consume.Consume1;
import org.jdr.project.mq.queue.consume.Consume2;

/**
 * 延迟队列消费异常时抛出此{@link Consume1},{@link Consume2}
 *
 * @author zhoude
 * @date 2021/1/29 15:49
 */
public class DelayConsumeException extends RuntimeException {
}