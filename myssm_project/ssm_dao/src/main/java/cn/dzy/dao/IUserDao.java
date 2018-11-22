package cn.dzy.dao;

import cn.dzy.domain.Role;
import cn.dzy.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {



@Select("select * from users where username=#{username}")
@Results({
        @Result(property = "roles",column = "id",javaType =java.util.List.class,many = @Many(select = "cn.dzy.dao.IRoleDao.findRoleByUserId"))
        })
  UserInfo findUserByName(String username);
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users")
    List<UserInfo> findAll();


    @Select("select * from users where id=#{id}")
    @Results({
            /*一定要写，不然后面根据角色添加id会报错*/
            @Result(property = "id",column = "id"),
            @Result(property = "roles",column = "id",many = @Many(select = "cn.dzy.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);
    //根据userid查询该user没有的角色
   @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
   List<Role> findOtherRoles(String userId);


    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

}
