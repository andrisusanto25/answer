package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.ShippingMethods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShippingMethodsMapper extends BaseMapper<Integer, ShippingMethods> {

}