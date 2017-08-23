package com.feng.entity;
import java.util.Date;

/**
 * Created by TTfly on 2017/5/18.
 */
public class SuccessKilled {

    private long secKillId;

    private long userPhone;

    private short state;

    private Date createTime;

    //多对一
    private SecKill secKill;

    public SuccessKilled() {
    }

    public SecKill getSecKill() {
        return secKill;
    }

    public void setSecKill(SecKill secKill) {
        this.secKill = secKill;
    }

    public long getSecKillId() {
        return secKillId;
    }
    public void setSecKillId(long secKillId) {
        this.secKillId = secKillId;
    }
    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "secKillId=" + secKillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", secKill=" + secKill +
                '}';
    }
}
