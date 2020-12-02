package springbook.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:test-applicationContext.xml")
public class TestApplicationContext {
}
