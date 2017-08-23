package com.feng.Service;

import com.feng.dto.ExposerDTO;
import com.feng.dto.SeckillExecutionDTO;
import com.feng.entity.SecKill;
import com.feng.exception.SeckillException;

import java.util.List;


/**
 * 业务接口：站在"使用者"角度设计接口
 * 三个方面：
 * 1.方法定义粒度
 * 2.参数：越简练越直接越好
 * 3.返回类型：一定要友好，可以是类型或异常
 */
public interface SeckillService {

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecutionDTO executeSeckill(Long seckillId, Long userPhone, String md5)
            throws SeckillException;

    SecKill getSeckillById(Long seckillId);

    List<SecKill> getSeckillListByOffset(int offset, int limit);

    /**
     * 秒杀开启时输出秒杀接口的地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
     ExposerDTO exportSeckillUrl(Long seckillId);
}
