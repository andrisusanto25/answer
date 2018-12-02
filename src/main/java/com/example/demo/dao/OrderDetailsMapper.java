package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.OrderDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailsMapper extends BaseMapper<Integer, OrderDetails> {

}