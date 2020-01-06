package com.github.springbootjta.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午8:20 2020/1/5
 * 项目名称 spring-boot-jta
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Service
public class UserInfoService {

    @Resource
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "user:new")
    public void handle(String message) {
        log.info(message);
        jmsTemplate.convertAndSend("user:reply", "reply - " + message);
        if (message.contains("error")) {
            error();
        }
    }

    private void error() {
        throw new RuntimeException("error data!");
    }

}
