package com.subhasmita.streamverse.subscription.config;

import com.subhasmita.jwtsecurity.filters.JsonWebTokenFilter;
import com.subhasmita.jwtsecurity.service.JsonWebTokenService;
import com.subhasmita.jwtsecurity.service.UserService;
import com.subhasmita.jwtsecurity.service.impl.JsonWebTokenServiceImpl;
import com.subhasmita.jwtsecurity.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class for JWT (JSON Web Token).
 * It includes the settings for access and refresh tokens and provides Beans for JWT services and filters.
 */
@Configuration
public class JwtConfig {

    /** Expiration time for an access token. */
    @Value("${security.jwt.token.accessExpiration}")
    private Long accessExpiration;

    /** Expiration time for a refresh token. */
    @Value("${security.jwt.token.refreshToken}")
    private Long refreshExpiration;

    /** Secret key for token generation and verification. */
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${spring.application.name}")
    private String serviceName;

    @Bean
    public JsonWebTokenService jsonWebTokenService(){
        return new JsonWebTokenServiceImpl(serviceName, secretKey, accessExpiration, refreshExpiration);
    }

    @Bean
    public JsonWebTokenFilter jsonWebTokenFilter(JsonWebTokenService jsonWebTokenService, UserService userService){
        return new JsonWebTokenFilter(jsonWebTokenService, userService);
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
