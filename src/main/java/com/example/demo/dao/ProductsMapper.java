package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.Products;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductsMapper extends BaseMapper<Integer, Products> {

}