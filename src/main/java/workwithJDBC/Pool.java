package workwithJDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static workwithJDBC.MakeConnection.PASS;
import static workwithJDBC.MakeConnection.URL;
import static workwithJDBC.MakeConnection.USER;

public class Pool {

    public static Connection getConnection() throws SQLException {
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = getDataSource();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        Connection connection = dataSource.getConnection();
        return connection;
    }

    private ComboPooledDataSource cpds;

    private static ComboPooledDataSource getDataSource() throws IOException, SQLException, PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //cpds.setDriverClass("com.oracle.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASS);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
        return cpds;
    }
}


