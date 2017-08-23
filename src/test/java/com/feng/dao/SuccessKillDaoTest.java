package com.feng.dao;

import com.feng.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by TTfly on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKillDaoTest {

    @Resource
    private SuccessKillDao successKillDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000l;
        long userPhone = 15002336757l;
        int insertCount = successKillDao.insertSuccessKilled(id,userPhone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSecKill() throws Exception {
        long id = 1000l;
        long userPhone = 15002336757L;
        SuccessKilled successKilled = successKillDao.queryByIdWithSecKill(id,userPhone);
        System.out.println(successKilled);
    }

}