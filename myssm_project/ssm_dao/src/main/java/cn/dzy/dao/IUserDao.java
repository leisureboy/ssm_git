package cn.dzy.dao;

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
            @Result(property = "roles",column = "id",many = @Many(select = "cn.dzy.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

}
