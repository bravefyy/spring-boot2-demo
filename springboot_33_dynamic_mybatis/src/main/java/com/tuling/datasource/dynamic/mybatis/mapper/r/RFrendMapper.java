package com.tuling.datasource.dynamic.mybatis.mapper.r;


import com.tuling.datasource.dynamic.mybatis.entity.Frend;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: wangyi
 * @Date: 2020/12/12 01:16
 * @Description: 
 */
public interface RFrendMapper {
   // @Select("SELECT * FROM Frend")
    @Select("SELECT 'User'")
    // List<Frend> list();
    public String list();

    // @Insert("INSERT INTO  frend(`name`) VALUES (#{name})")
    @Select("select 'Order'")
    // void save(Frend frend);
    public String save(Frend frend);
}