
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnection {
    Connection con;
          PreparedStatement ps;
           String search;
         
    
     public Connection getConnection(){
        
         
        try {
             Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/cricket","root","");
            

            return con;
        } catch (Exception ex) {
            ex.getMessage();

          return null;   
        }
           
    }    
    
}
