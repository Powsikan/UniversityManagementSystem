
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseRepository implements Repository {

    @Override
    public ResultSet read(String query, String search) {
   ResultSet rs = null;
        DbConnection con =new DbConnection();
        Connection connector=con.getConnection();
        try {
            PreparedStatement ps=connector.prepareStatement(query);
            ps.setString(1,search);
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return rs;
    }
    
}
