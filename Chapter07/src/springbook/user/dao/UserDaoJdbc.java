package springbook.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoJdbc implements UserDao {
    private JdbcTemplate jdbcTemplate;

    private String sqlAdd;
    private String sqlGet;
    private String sqlDeleteAll;
    private String sqlGetCount;
    private String sqlGetAll;
    private String sqlUpdate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setSqlAdd(String sqlAdd) {
        this.sqlAdd = sqlAdd;
    }

    public void setSqlGet(String sqlGet) {
        this.sqlGet = sqlGet;
    }

    public void setSqlDeleteAll(String sqlDeleteAll) {
        this.sqlDeleteAll = sqlDeleteAll;
    }

    public void setSqlGetCount(String sqlGetCount) {
        this.sqlGetCount = sqlGetCount;
    }

    public void setSqlGetAll(String sqlGetAll) {
        this.sqlGetAll = sqlGetAll;
    }

    public void setSqlUpdate(String sqlUpdate) {
        this.sqlUpdate = sqlUpdate;
    }

    private RowMapper<User> userMapper = (resultSet, rowNum) -> {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setLevel(Level.valueOf(resultSet.getInt("level")));
        user.setLogin(resultSet.getInt("login"));
        user.setRecommend(resultSet.getInt("recommend"));
        user.setEmail(resultSet.getString("email"));
        return user;
    };

    @Override
    public void add(final User user) {
        this.jdbcTemplate.update(
            this.sqlAdd,
            user.getId(), user.getName(), user.getPassword(),
            user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail());
    }

    @Override
    public User get(String id) {
        return this.jdbcTemplate.queryForObject(
            this.sqlGet,
            new Object[] { id }, userMapper);
    }

    @Override
    public void deleteAll() {
        this.jdbcTemplate.update(this.sqlDeleteAll);
    }

    @Override
    public int getCount() {
        return this.jdbcTemplate.queryForObject(this.sqlGetCount, Integer.class);
    }

    @Override
    public List<User> getAll() {
        return this.jdbcTemplate.query(this.sqlGetAll, userMapper);
    }

    @Override
    public void update(User user) {
        this.jdbcTemplate.update(
            "UPDATE users SET name = ?, password = ?, level = ?, login = ?, recommend = ?, email = ? " +
            "WHERE id = ?",
            user.getName(), user.getPassword(), user.getLevel().intValue(),
            user.getLogin(), user.getRecommend(), user.getEmail(), user.getId());
    }
}