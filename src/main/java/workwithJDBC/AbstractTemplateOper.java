package workwithJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractTemplateOper<T> {

    public boolean templateOperation(T t) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isSuccessful = false;
        try {
            connection = Pool.getConnection();
            stmt = returnPrepareStatement(t, connection);
            isSuccessful = stmt.executeUpdate() > 0;

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
        return isSuccessful;
    }

    public abstract PreparedStatement returnPrepareStatement(T t, Connection conn) throws SQLException;
}

