package workwithJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@FunctionalInterface
public interface TemplOperation <T>{
    public default boolean templateOperationFromInterface (T t) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowDeleted = false;
        try {
            connection = Pool.getConnection();
            stmt = returnPrepareStatement(t, connection);
            isRowDeleted = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowDeleted;
    }
    public abstract PreparedStatement returnPrepareStatement(T t, Connection conn) throws SQLException;

}