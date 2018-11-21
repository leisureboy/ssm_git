package cn.dzy.dao;

import cn.dzy.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IproductDao {
        //根据id查询产品
        @Select("select * from product where id=#{id}")
        public Product findById(String id) throws Exception;

        //查询所有的产品信息
        @Select("select * from product")
        public List<Product> findAll() throws Exception;

        @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
                "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
        void save(Product product);

}
