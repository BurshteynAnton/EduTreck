package antonburshteyn.security;

import antonburshteyn.authentication.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import static antonburshteyn.authentication.model.Role.ADMINISTRATOR;


@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    final CustomWebSecurity customWebSecurity;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic((Customizer.withDefaults()));
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/auth/register")
                .permitAll()
                    .requestMatchers("/auth/login")
                .permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/auth/user/{userId}")
                .hasAuthority("ADMINISTRATOR")
                .anyRequest().authenticated()


        );
        return http.build();
    }
}
