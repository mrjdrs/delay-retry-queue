package org.jdr.project.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelayRetryQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelayRetryQueueApplication.class, args);
    }

}
