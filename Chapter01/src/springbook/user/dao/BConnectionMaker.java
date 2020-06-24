package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BConnectionMaker implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException();
    }
}
