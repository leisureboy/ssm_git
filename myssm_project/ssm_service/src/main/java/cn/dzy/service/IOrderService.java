package cn.dzy.service;

import cn.dzy.domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
