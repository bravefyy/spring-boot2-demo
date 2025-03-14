package com.itheima.mapper.s1;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountS1Mapper {
    @Select("select count(0) from t_sbm_chnl_param")
    Integer getCountS1();
}
