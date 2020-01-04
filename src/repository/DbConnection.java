
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnection {
    Connection con;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system", "root", "");
            return con;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }

    }

}
