package cn.dzy.service;

import cn.dzy.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    void save(UserInfo userInfo);

    List<UserInfo> findAll();
    UserInfo findById(String id);
}
