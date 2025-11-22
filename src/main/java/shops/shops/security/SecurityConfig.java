package shops.shops.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* *
import shops.shops.costumouthservice.Coustomouthservice;

 @EnableWebSecurity
   @Configuration
 
public class SecurityConfig {

     @Autowired
    private Coustomouthservice coustomouthservice;
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("api/admin/addproduct").permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2

            .userInfoEndpoint(userInfo -> userInfo
                    .userService(coustomouthservice)
                )
                .defaultSuccessUrl("/profile", true)
            );

            
        return http.build();
    }  
    
}
 */