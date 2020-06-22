package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("foo");
        user.setName("bar");
        user.setPassword("test");

        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost/springbook?verifyServerCertificate=false&useSSL=true", "spring", "book");

        PreparedStatement ps = c.prepareStatement(
            "INSERT INTO users(id, name, password) VALUES(?, ?, ?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/springbook?verifyServerCertificate=false&useSSL=true", "spring", "book");

        PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
 }
