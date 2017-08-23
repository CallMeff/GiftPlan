package com.feng.controller;

import com.feng.dto.CommonResult;
import com.feng.entity.Fanxing;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by TTfly on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

public class TestControllerTest {

    @Autowired
    private TestController testController;

    @Test
    public void getSeckill() throws Exception {

    }

    @Test
    public void getGift() throws Exception {
        CommonResult<PageInfo> pageInfo = testController.getFestivals(1,5,"sadas");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(pageInfo);
        System.out.println(jsonStr);
    }

    @Test
    public void testFanxing(){
        Fanxing<String,Object> fanxing = new Fanxing();
        getParam(fanxing);
    }


    public void getParam(Fanxing<String,Object> f){

    }

}