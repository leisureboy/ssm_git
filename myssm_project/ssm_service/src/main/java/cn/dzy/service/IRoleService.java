package cn.dzy.service;

import cn.dzy.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    void save(Role role);
}
