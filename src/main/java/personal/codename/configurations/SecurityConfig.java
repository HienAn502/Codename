package personal.codename.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/api-docs/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.requestMatchers(SWAGGER_WHITELIST).permitAll()
                .anyRequest().authenticated());
        return http.build();
    }
}
