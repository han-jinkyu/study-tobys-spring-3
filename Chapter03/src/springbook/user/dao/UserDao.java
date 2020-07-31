package springbook.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public void add(final User user) {
        this.jdbcTemplate.update(
            "INSERT INTO users(id, name, password) VALUES(?, ?, ?)",
            user.getId(), user.getName(), user.getPassword());
    }

    public User get(String id) throws SQLException {
        return this.jdbcTemplate.queryForObject(
            "SELECT * FROM users WHERE id = ?",
            new Object[] { id },
            (resultSet, rowNum) -> {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            });
    }

    public void deleteAll() {
        this.jdbcTemplate.update("DELETE FROM users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM users ORDER BY id",
                (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                });
    }
}
