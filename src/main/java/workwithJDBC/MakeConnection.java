package workwithJDBC;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Locale;

public class MakeConnection {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "MA_STUDENT";
    public static final String PASS = "KOLOBOK";


    public  static Connection getConnection(){
        Connection conn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
