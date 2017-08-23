package com.feng.dao;

import com.feng.entity.SecKill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by TTfly on 2017/5/18.
 */
public interface SecKillDao {

    /**
     * @description 减库存
     * @param secKillId
     * @param killTime
     * @return
     */
     int reduceNumber(@Param("secKillId") Long secKillId, @Param("killTime") Date killTime);

    /**
     * @param secKillId
     * @return
     */
     SecKill queryById(long secKillId);

    /**
     * @description 分页查询
     * @param offset
     * @param limit
     * @return
     */
     List<SecKill> queryByOffset(@Param("offset") int offset, @Param("limit") int limit);
}
