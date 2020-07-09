package springbook.user.dao;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        // 귀찮아서 삭제 로직 추가
        dao.removeAll();

        User user = new User();
        user.setId("foo");
        user.setName("bar");
        user.setPassword("test");

        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));
    }

    public static void main(String[] args) {
        JUnitCore.main("springbook.user.dao.UserDaoTest");
    }
}
