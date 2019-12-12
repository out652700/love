package com.word.wm.main.wm_controller;

import com.alibaba.fastjson.JSON;
import com.word.wm.main.entity.Test;
import com.word.wm.main.wm_dao.test.TestDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author hzc65
 * @Date 2019/11/19 11 03
 * @Describe
 */
@RestController
@RequestMapping(value = "/test")
@Api(tags = "测试api")
public class testCl {

    @Autowired
    private TestDao testDao;

    @RequestMapping(value = "/one",method = RequestMethod.GET)
    @ApiOperation(value = "测试", notes = "备注", httpMethod = "GET")
    String getTest(@RequestParam String name){
        Test t =new Test();
        t.setName("测试通过");
        System.out.println(t.toString());
        System.out.println("name"+name);
        String res=testDao.getTest(name);

        return JSON.toJSONString(res);
    }

    @RequestMapping(value = "/two",method = RequestMethod.POST)
    @ApiOperation(value = "测试2", notes = "备注", httpMethod = "POST")
    String getTestList(){
        System.out.println("集合查询");
        return JSON.toJSONString(testDao.getTest2());
    }

}
