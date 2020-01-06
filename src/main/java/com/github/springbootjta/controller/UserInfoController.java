package com.github.springbootjta.controller;

import com.github.springbootjta.pojo.UserInfoDO;
import com.github.springbootjta.repository.UserInfoRepository;
import com.github.springbootjta.service.UserInfoService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:17 2020/1/5
 * 项目名称 spring-boot-jta
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserInfoController {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private UserInfoService service;

    @Resource
    private UserInfoRepository repository;

    @GetMapping("/")
    public List<UserInfoDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/data1/{data}")
    public String send1(@PathVariable String data) {
        service.handle(data);
        return data;
    }

    @GetMapping("/data2/{data}")
    public String send2(@PathVariable String data) {
        jmsTemplate.convertAndSend("user:new", data);
        return data;
    }


    @GetMapping("/data")
    public String getData() {
        jmsTemplate.setReceiveTimeout(2000);
        return (String) jmsTemplate.receiveAndConvert("user:reply");
    }

}
