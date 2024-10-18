package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())  {
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "Lifeisgreat@4509");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

}
}
