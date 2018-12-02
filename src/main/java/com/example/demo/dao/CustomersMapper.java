package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.Customers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomersMapper extends BaseMapper<Integer, Customers> {

}