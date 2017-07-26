/** 
 * File Name：RedisCacheConfig.java 
 * 
 * Copyright Defonds Corporation 2015  
 * All Rights Reserved 
 * 
 */  
package com.defonds.bdp.cache.redis;  
  
import org.springframework.cache.CacheManager;  
import org.springframework.cache.annotation.CachingConfigurerSupport;  
import org.springframework.cache.annotation.EnableCaching;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.data.redis.cache.RedisCacheManager;  
import org.springframework.data.redis.connection.RedisConnectionFactory;  
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;  
import org.springframework.data.redis.core.RedisTemplate;  
  
/** 
 *  
 * Project Name：bdp  
 * Type Name：RedisCacheConfig  
 * Type Description： 
 *  Author：Defonds 
 * Create Date：2015-09-21 
 *  
 * @version 
 *  
 */  
@Configuration  
@EnableCaching  
public class RedisCacheConfig extends CachingConfigurerSupport {  
  
    @Bean  
    public JedisConnectionFactory redisConnectionFactory() {  
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
  
        // Defaults  
        try{
        redisConnectionFactory.setHostName("localhost");  
        redisConnectionFactory.setPort(6379);  
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Connect Redis Fail!");
		}
        return redisConnectionFactory;  
    }  
  
    @Bean  
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {  
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();  
        redisTemplate.setConnectionFactory(cf);  
        return redisTemplate;  
    }  
  
    @Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
  
        // Number of seconds before expiration. Defaults to unlimited (0)  
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)  
        return cacheManager;  
    }  
      
}  