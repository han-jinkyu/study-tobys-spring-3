package springbook.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import springbook.user.service.DummyMailSender;
import springbook.user.service.UserService;
import springbook.user.service.UserServiceTest;

@Configuration
@Profile("test")
public class TestAppContext {

    @Bean
    public UserService testUserService() {
        return new UserServiceTest.TestUserService();
    }

    @Bean
    public MailSender mailSender() {
        return new DummyMailSender();
    }
}
