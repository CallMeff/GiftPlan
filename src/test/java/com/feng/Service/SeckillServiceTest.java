package com.feng.Service;

import com.feng.dto.ExposerDTO;
import com.feng.dto.SeckillExecutionDTO;
import com.feng.entity.SecKill;
import com.feng.exception.RepeatKillException;
import com.feng.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * SeckillService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 11, 2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    /**
     * Method: exportSeckillUrl(long seckillId)
     * ExposerDTO{exposed=true, md5='bcc156cc7000c9cacdcd9c9f2a666f82', seckillId=1000, now=0, start=0, end=0}
     */
    @Test
    public void testExportSeckillUrl() throws Exception {
        long seckillId = 1000L;
        ExposerDTO exposerDTO = seckillService.exportSeckillUrl(seckillId);
        logger.info("exposer={}", exposerDTO);
    }

    /**
     * Method: executeSeckill(long seckillId, long userPhone, String md5)
     */
    @Test
    public void testExecuteSeckill() throws Exception {
        long seckillId = 1000;
        long phone = 15222155465L;
        String md5 = "bcc156cc7000c9cacdcd9c9f2a666f82";
        try {
            SeckillExecutionDTO executionDTO = seckillService.executeSeckill(seckillId, phone, md5);
        } catch (RepeatKillException e1) {
            logger.error(e1.getMessage());
        } catch (SeckillCloseException e2) {
            logger.error(e2.getMessage());
        }

    }

    @Test
    public void testSeckillLogic(){
        long seckillId = 1000L;
        ExposerDTO exposerDTO = seckillService.exportSeckillUrl(seckillId);
        if(exposerDTO.isExposed()){
            logger.info("exposer={}", exposerDTO);
            long phone = 15222155465L;
            String md5 = exposerDTO.getMd5();
            try {
                SeckillExecutionDTO executionDTO = seckillService.executeSeckill(seckillId, phone, md5);
            } catch (RepeatKillException e1) {
                logger.error(e1.getMessage());
            } catch (SeckillCloseException e2) {
                logger.error(e2.getMessage());
            }
        }else {
            //ÃëÉ±Î´¿ªÆô
            logger.warn("result={}", exposerDTO);

        }
    }
    /**
     * Method: getSeckillById(long seckillId)
     */
    @Test
    public void testGetSeckillById() throws Exception {
        long seckillId = 1000L;
        SecKill seckill = seckillService.getSeckillById(seckillId);
        logger.info("seckill={}", seckill);
    }

    /**
     * Method: getSeckillListByOffset(int offset, int limit)
     */
    @Test
    public void testGetSeckillListByOffset() throws Exception {
        int offset = 0;
        int limit = 5;
        List<SecKill> secKillList = seckillService.getSeckillListByOffset(offset, limit);
        logger.info("list={}", secKillList);
    }


}
