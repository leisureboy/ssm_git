package cn.dzy.dao;

import cn.dzy.domain.Permission;
import cn.dzy.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.dzy.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role")
    List<Role> findAll();


    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "permissions",column = "id",
                    many = @Many(select = "cn.dzy.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
