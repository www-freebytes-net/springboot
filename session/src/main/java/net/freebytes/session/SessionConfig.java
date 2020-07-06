package net.freebytes.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @date: 2020/7/6 15:39
 */
@ComponentScan({"net.freebytes.session"})
public class SessionConfig {
    @Bean
    public SessionComponent sessionComponent() {
        return new SessionComponent();
    }
}
