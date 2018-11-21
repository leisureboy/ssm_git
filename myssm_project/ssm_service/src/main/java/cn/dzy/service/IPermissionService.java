package cn.dzy.service;

import cn.dzy.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();
    void save(Permission permission);
}
