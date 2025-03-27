package project.redis.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        Map<String, org.redisson.spring.cache.CacheConfig> configMap = new HashMap<>();

        // TTL: 10분, MaxIdleTime: 5분 (단위: 밀리초)
        configMap.put("current_playing_movie", new org.redisson.spring.cache.CacheConfig(600_000L, 300_000L));

        RedissonSpringCacheManager manager = new RedissonSpringCacheManager(redissonClient, configMap);
        manager.setCodec(new JsonJacksonCodec()); // 이 부분 중요
        return manager;
    }

//    @Bean
//    public CaffeineCacheManager cacheManager() {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager("current_playing_movie");
//        cacheManager.setCaffeine(caffeineCacheBuilder());
//        cacheManager.setAsyncCacheMode(true);
//        return cacheManager;
//    }

    @Bean
    public Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(500);
    }

}