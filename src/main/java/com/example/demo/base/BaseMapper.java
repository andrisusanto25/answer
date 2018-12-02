package com.example.demo.base;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BaseMapper<PK, M> {

    int deleteByPrimaryKey(PK id);

    int insert(M record);

    int insertSelective(M record);

    M selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(M record);

    int updateByPrimaryKey(M record);
}
