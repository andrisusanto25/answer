package com.example.demo.dao;

import com.example.demo.base.BaseMapper;
import com.example.demo.model.Employees;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeesMapper extends BaseMapper<Integer, Employees> {

}