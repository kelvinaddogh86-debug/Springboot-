package shops.shops.frontconfigration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorseConfigration implements WebMvcConfigurer {

    public void addcorsConfigration( CorsRegistry registry){
      registry.addMapping("/")
            .allowedOrigins(
                "http"

            )
            .allowedMethods("/")
            .allowedHeaders("/")
            .allowCredentials(true);
    }       

}
