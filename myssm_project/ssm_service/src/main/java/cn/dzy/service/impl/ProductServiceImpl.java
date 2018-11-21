package cn.dzy.service.impl;


import cn.dzy.dao.IproductDao;
import cn.dzy.domain.Product;
import cn.dzy.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IproductDao productDao;
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll(int page,int size) throws Exception{
        PageHelper.startPage(page,size);//从page开始查size个
        return productDao.findAll();
    }
}
