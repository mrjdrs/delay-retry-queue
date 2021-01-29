package org.jdr.project.mq.queue.consume;

import lombok.extern.slf4j.Slf4j;
import org.jdr.project.mq.queue.definition.DelayConsumeException;
import org.springframework.stereotype.Component;

/**
 * @author zhoude
 * @date 2021/1/29 15:47
 */
@Component
@Slf4j
public class Consume1 implements DelayConsume<String> {

    @Override
    public String consumerKey() {
        return this.getClass().getName();
    }

    @Override
    public void handle(String payLoad) {
        try {
            System.out.println("Consume1消费了" + payLoad);
            throw new RuntimeException("error");
        }
        catch (Exception e) {
            log.error("Consume1消费异常", e);
            throw new DelayConsumeException();
        }
    }

}