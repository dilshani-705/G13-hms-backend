package com.hms.hms;

import com.hms.hms.User.AllUserMapper.SubWardenMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public SubWardenMapper subWardenMapper(PasswordEncoder passwordEncoder){
        return new SubWardenMapper(passwordEncoder);
    }
}
