package com.feng.dao;

import com.feng.entity.SecKill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * SecKillDao Tester.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {

    @Resource
    private SecKillDao secKillDao;

    /**
     * Method: reduceNumber(long secKillId, Date killTime)
     */
    @Test
    public void testReduceNumber() throws Exception {
        secKillDao.reduceNumber(1000L,new Date());
        SecKill secKill = secKillDao.queryById(1000);
        System.out.println(secKill);
    }

    /**
     * Method: queryById(long secKillId)
     */
    @Test
    public void testQueryById() throws Exception {
        Long id = 1000L;
        SecKill secKill = secKillDao.queryById(id);
        System.out.println(secKill.getName());
        System.out.println(secKill);
    }

    /**
     * Method: queryByOffset(int offset, int limit)
     */
    @Test
    public void testQueryByOffset() throws Exception {
        List<SecKill> secKillList = secKillDao.queryByOffset(0,100);
        for (SecKill seckill:secKillList) {
            System.out.println(seckill);
        }
    }


} 
