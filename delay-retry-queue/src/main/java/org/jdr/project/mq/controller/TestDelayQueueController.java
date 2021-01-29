package org.jdr.project.mq.controller;

import lombok.AllArgsConstructor;
import org.jdr.project.mq.queue.consume.Consume1;
import org.jdr.project.mq.queue.definition.DelayTime;
import org.jdr.project.mq.queue.definition.ExceptionRetryStrategy;
import org.jdr.project.mq.queue.delay.DelayQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoude
 * @date 2021/1/29 14:09
 */
@RestController
@RequestMapping("/testDelayQueue")
@AllArgsConstructor
public class TestDelayQueueController {

    private final DelayQueue delayQueue;

    @GetMapping("/sendFive")
    public String sendFive() {
        delayQueue.send("123", DelayTime.FIVE_SECONDS, ExceptionRetryStrategy.FIVE_NOTIFY, Consume1.class.getName());
        return "200";
    }

    @GetMapping("/customize")
    public String customize() {
        delayQueue.send("123", DelayTime.FIVE_SECONDS, ExceptionRetryStrategy.CUSTOMIZE.resetRetryCount(10), Consume1.class.getName());
        return "200";
    }

}