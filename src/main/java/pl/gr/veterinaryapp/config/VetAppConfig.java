package pl.gr.veterinaryapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Clock;

@Configuration
public class VetAppConfig {

    @Bean
    public Clock systemClock() {
        return Clock.systemUTC();
    }

}
