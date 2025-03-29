package net.javaguides.springboot.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf(csrf -> csrf.disable()) // 🔴 Desabilita proteção CSRF (se
                        // necessário)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").authenticated() // 🔒 Protege a API
                        .anyRequest().permitAll() // 🔓 Permite outras requisições sem autenticação
                )
                .formLogin(withDefaults()) // 🔑 Habilita o login padrão do Spring Security
                .httpBasic(withDefaults()); // 🔑 Habilita autenticação HTTP Basic

        return http.build();
    }
}
