package com.github.springbootjta.service;

import com.github.springbootjta.pojo.UserInfoDO;
import com.github.springbootjta.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private UserInfoRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public UserInfoDO save(UserInfoDO userInfo) {
        UserInfoDO result = repository.save(userInfo);
        jmsTemplate.convertAndSend("user:msg:reply", userInfo.toString());
        if (userInfo.getUsername().contains("error")) {
            throw new RuntimeException("user error");
        }
        return result;
    }

}
