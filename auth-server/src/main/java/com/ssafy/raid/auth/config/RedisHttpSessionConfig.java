package com.ssafy.raid.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession()
public class RedisHttpSessionConfig {
	
	@Value("${spring.redis.host}")
	String host;
	
	@Value("${spring.redis.port}")
	int port;
	
	@Value("${spring.redis.password}")
	String password;
	
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		LettuceConnectionFactory lcf = new LettuceConnectionFactory(host, port);
		lcf.getStandaloneConfiguration().setPassword(password);
		return lcf;
	}
	

}
