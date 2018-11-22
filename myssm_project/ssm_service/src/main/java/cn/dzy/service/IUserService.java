package cn.dzy.service;

import cn.dzy.domain.Role;
import cn.dzy.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    void save(UserInfo userInfo);

    List<UserInfo> findAll();
    UserInfo findById(String id);
    List<Role> findOtherRoles(String userId);
    void addRoleToUser(String userId, String[] roleIds);
}
