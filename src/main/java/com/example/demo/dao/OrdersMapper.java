package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Integer, Orders> {

    List<Orders> selectOrdersPage(Orders orders);
}