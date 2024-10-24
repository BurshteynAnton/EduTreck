package antonburshteyn.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;


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
                .hasRole("ADMINISTRATOR")
                    .requestMatchers(HttpMethod.PUT,"/auth/user/{userName}")
                .access(new WebExpressionAuthorizationManager("#userName == authentication.name or hasRole('ADMINISTRATOR')"))
                    .requestMatchers(HttpMethod.PUT, "/auth/password/{userName}")
                .access(new WebExpressionAuthorizationManager("#userName == authentication.name or hasRole('ADMINISTRATOR')"))
                    .requestMatchers(HttpMethod.GET, "/auth/user/{userName}")
                .access(new WebExpressionAuthorizationManager("#userName == authentication.name or hasRole('ADMINISTRATOR')"))
                    .requestMatchers(HttpMethod.PUT, "/auth/user/{userName}/role/{role}")
                .hasRole("ADMINISTRATOR")
                    .requestMatchers(HttpMethod.DELETE, "/auth/user/{userName}/role/{role}")
                .hasRole("ADMINISTRATOR")
                    .anyRequest().authenticated()

                // Security rules for ContactController
                    .requestMatchers(HttpMethod.POST, "/contact")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.POST, "/contact/{contactId}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/{contactId}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/{size}/{page}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/all")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/name/{name}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/lastName/{lastName}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.GET, "/contact/status/{status}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.PUT, "/contact/{contactId}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.POST, "/contact/{contactId}/comment")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.PUT, "/contact/{contactId}/comment/{commentId}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.PUT, "/contact/{contactId}/reminder")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.DELETE, "/contact/{contactId}")
                .hasRole("ADMINISTRATOR") // Remove contact
                    .requestMatchers(HttpMethod.DELETE, "/contact/{contactId}/comment/{commentId}")
                .hasAnyRole("USER", "ADMINISTRATOR")
                    .requestMatchers(HttpMethod.DELETE, "/contact/{contactId}/reminder/{reminderId}")
                .hasAnyRole("USER", "ADMINISTRATOR")


        );
        return http.build();
    }
}
