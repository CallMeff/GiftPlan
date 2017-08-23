package com.feng.Service.impl;

import com.feng.Service.SeckillService;
import com.feng.dao.SecKillDao;
import com.feng.dao.SuccessKillDao;
import com.feng.dto.ExposerDTO;
import com.feng.dto.SeckillExecutionDTO;
import com.feng.entity.SecKill;
import com.feng.entity.SuccessKilled;
import com.feng.enums.SeckillStateEnum;
import com.feng.exception.RepeatKillException;
import com.feng.exception.SeckillCloseException;
import com.feng.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by TTfly on 2017/6/10.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    //日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillDao secKillDao;

    @Autowired
    private SuccessKillDao successKillDao;

    //用于混淆MD5
    private final String slat = "asdasfas@!#DASD@!$%!@Edgarwqreasdfasfdasfas21#RFDSF%$#^#$%WQDSAF124123r";

    public List<SecKill> getSeckillListByOffset(int offset, int limit) {
        return secKillDao.queryByOffset(0,5);
    }

    public SecKill getSeckillById(Long seckillId) {
        return secKillDao.queryById(seckillId);
    }

    /**
     *
     * 使用注解控制事务方法的优点：
     * 1.开发团队打成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作（RPC/HTTP请求），如果必要，则剥离到事务方法外
     * 3.不是所有的方法都需要事务，只有一条修改操作或只读操作不需要事务控制
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    @Transactional
    public SeckillExecutionDTO executeSeckill(Long seckillId, Long userPhone, String md5) throws SeckillException {

        if(md5 == null || !md5.equals(getMD5(seckillId))){
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑,减库存 + 记录购买行为
        Date nowTime = new Date();
        try {
            //减库存
            int updateCount = secKillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录，秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                //记录购买行为
                int insertCount = successKillDao.insertSuccessKilled(seckillId, userPhone);
                //唯一
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKillDao.queryByIdWithSecKill(seckillId, userPhone);
                    return new SeckillExecutionDTO(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        }catch (SeckillCloseException sce){
            throw sce;
        }catch (RepeatKillException rke){
            throw  rke;
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            //所有编译期异常转化为运行期异常
            throw  new SeckillException("seckill inner error" + e.getMessage());
        }
    }

    public ExposerDTO exportSeckillUrl(Long seckillId) {
        SecKill secKill = secKillDao.queryById(seckillId);
        if(secKill == null){
            return new ExposerDTO(false,seckillId);
        }
        Long startTime = secKill.getStartTime().getTime();
        Long endTime = secKill.getEndTime().getTime();
        Long nowTime = new Date().getTime();
        if(nowTime<startTime || nowTime > endTime){
            return new ExposerDTO(false,seckillId,nowTime,startTime,endTime);
        }
        //转化特定字符串的过程，不可逆
        String md5 = getMD5(seckillId); //TODO
        return new ExposerDTO(true,md5,seckillId);
    }

    private String getMD5(Long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
