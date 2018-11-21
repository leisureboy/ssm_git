package cn.dzy.dao;

import cn.dzy.domain.Orders;
import cn.dzy.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.List;

public interface IorderDao {
        @Select("select * from orders")
        @Results({
                @Result(property = "product", column = "productId", javaType = Product.class,
                        one = @One(select = "cn.dzy.dao.IproductDao.findById")),
        })
        public List<Orders> findAll() throws Exception;

        //多表操作
        @Select("select * from orders where id=#{ordersId}")
        @Results({
                @Result(property = "product", column = "productId", javaType = Product.class,
                        one = @One(select = "cn.dzy.dao.IproductDao.findById")),
                @Result(property = "member", column = "memberId", javaType = Member.class,
                        one = @One(select = "cn.dzy.dao.IMemberDao.findById")),
                @Result(property = "travellers", column = "id", javaType = java.util.List.class,
                        many = @Many(select = "cn.dzy.dao.ITravellerDao.findByOrdersId"))
        })
        public Orders findById(String ordersId) throws Exception;

}
