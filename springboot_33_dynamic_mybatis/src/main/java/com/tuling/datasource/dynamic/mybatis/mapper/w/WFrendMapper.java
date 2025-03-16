package com.tuling.datasource.dynamic.mybatis.mapper.w;


import com.tuling.datasource.dynamic.mybatis.entity.Frend;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: wangyi
 * @Date: 2020/12/12 01:16
 * @Description: 
 */
public interface WFrendMapper {
    // @Select("SELECT * FROM Frend")
    @Select("SELECT 'writer'")
    // List<Frend> list();
    public String list();

    // @Insert("INSERT INTO  frend(`name`) VALUES (#{name})")
    @Select("select 'writer1'")
    // void save(Frend frend);
    public String save(Frend frend);
}