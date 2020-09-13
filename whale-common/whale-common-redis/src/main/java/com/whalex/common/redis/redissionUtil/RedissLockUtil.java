package com.whalex.common.redis.redissionUtil;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Description: 分布式锁
 *
 * @author: 🐋鲸鱼
 * date: 2020/9/13 20:26
 */
@Component
public class RedissLockUtil {

    @Autowired
    private  RedissonClient redissonClient;

    /**
     * 加锁
     * @param lockKey 锁名称
     * @return
     */
    public RLock lock(String lockKey) {
        RLock rLock =  redissonClient.getLock(lockKey);
        rLock.lock();
        return rLock;
    }

    /**
     * 加锁并设置释放时间
     * @param lockKey 锁名称
     * @param times 时间
     * @return
     */
    public RLock lock(String lockKey,Long times) {
        RLock rLock =  redissonClient.getLock(lockKey);
        rLock.lock(times,TimeUnit.SECONDS);
        return rLock;
    }


    /**
     * 加锁并设置释放时间
     * @param lockKey 锁名称
     * @param timeUnit 时间单位
     * @param times 时间
     * @return
     */
    public RLock lock(String lockKey,TimeUnit timeUnit,Long times) {
        RLock rLock =  redissonClient.getLock(lockKey);
        rLock.lock(times,timeUnit);
        return rLock;
    }

    /**
     * 尝试获取锁
     * @param lockKey 锁名称
     * @param timeUnit 时间单位
     * @param waitTime 等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public boolean tryLock(String lockKey, TimeUnit timeUnit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, timeUnit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    /**
     * 释放锁
     * @param lockKey
     */
    public  void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

}
