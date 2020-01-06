package com.github.springbootjta.controller;

import com.github.springbootjta.pojo.UserInfoDO;
import com.github.springbootjta.repository.UserInfoRepository;
import com.github.springbootjta.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private UserInfoService service;

    @Resource
    private UserInfoRepository repository;

    @GetMapping("/")
    public List<UserInfoDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("/user")
    public UserInfoDO save(@RequestBody UserInfoDO userInfo) {
        return service.save(userInfo);
    }

}
