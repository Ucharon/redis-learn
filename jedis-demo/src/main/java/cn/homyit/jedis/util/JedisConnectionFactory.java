package cn.homyit.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);//最大连接
        poolConfig.setMaxIdle(8);//最大空闲连接
        poolConfig.setMinIdle(0);//最小空闲连接
        poolConfig.setMaxWaitMillis(1000);//等待市场
        //创建连接池对象
        jedisPool = new JedisPool(poolConfig,
                "101.34.210.50",6379,1000,"123321");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
