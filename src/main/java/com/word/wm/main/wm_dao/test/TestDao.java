package com.word.wm.main.wm_dao.test;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author hzc65
 * @Date 2019/11/26 17 06
 * @Describe
 */

@Repository
@Mapper
public interface TestDao {


    @Select("select s.goodsCode FROM goods s WHERE s.goods_info = #{name}")
    String getTest(String name);

    @Select("select s.goodsCode FROM goods s")
    List<Map<String,Object>> getTest2();
}
