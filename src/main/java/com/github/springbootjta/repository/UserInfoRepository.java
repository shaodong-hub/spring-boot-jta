package com.github.springbootjta.repository;

import com.github.springbootjta.pojo.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午8:15 2020/1/5
 * 项目名称 spring-boot-jta
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface UserInfoRepository extends JpaRepository<UserInfoDO, Integer> {
}
