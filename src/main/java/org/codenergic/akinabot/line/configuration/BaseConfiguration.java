package org.codenergic.akinabot.line.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by diasa on 2/19/17.
 */
@Configuration
public class BaseConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.build();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        try {
            String redisUrl = System.getenv("REDIS_URL");
            URI redisUri = new URI(redisUrl);
            JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
            jedisConnFactory.setUsePool(true);
            jedisConnFactory.setHostName(redisUri.getHost());
            jedisConnFactory.setPort(redisUri.getPort());
            jedisConnFactory.setPassword(redisUri.getUserInfo().split(":", 2)[1]);
            return jedisConnFactory;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
