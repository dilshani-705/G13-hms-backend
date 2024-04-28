package com.hms.hms;

import com.hms.hms.User.AllUserMapper.*;
import com.hms.hms.User.UserEntity.Dean;
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
    @Bean
    public AdminMapper adminMapper(PasswordEncoder passwordEncoder){
        return new AdminMapper(passwordEncoder);
    }
    @Bean
    public DeanMapper deanMapper(PasswordEncoder passwordEncoder){
        return new DeanMapper(passwordEncoder);
    }
    @Bean
    public WardenMapper wardenMapper(PasswordEncoder passwordEncoder){
        return new WardenMapper(passwordEncoder);
    }
    @Bean
    public StudentMapper studentMapper(PasswordEncoder passwordEncoder){
        return new StudentMapper(passwordEncoder);
    }
    @Bean
    public MaintenanceSupervisorMapper maintenanceSupervisorMapper(PasswordEncoder passwordEncoder){
        return new MaintenanceSupervisorMapper(passwordEncoder);
    }

}
