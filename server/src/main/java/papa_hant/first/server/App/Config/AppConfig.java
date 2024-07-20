package papa_hant.first.server.App.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import papa_hant.first.server.routes.token.TokenService;
import papa_hant.first.server.routes.user.service.TimedMap;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    public TokenService tokenService() {
        return new TokenService();
    }

    @Bean
    public TimedMap timedMap() {
        return new TimedMap();
    }

}
