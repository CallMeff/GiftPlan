package com.feng.dao;

import com.feng.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by TTfly on 2017/5/18.
 */
public interface SuccessKillDao {

    /**
     * @description 插入购买明细，可过滤重复
     * @param secKillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("secKillId") Long secKillId, @Param("userPhone") Long userPhone);

    /**
     * 通过id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSecKill(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);
}
