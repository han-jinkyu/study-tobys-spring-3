package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException();
    }
}
