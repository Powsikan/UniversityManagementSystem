
package repository;

import java.sql.ResultSet;

public interface Repository {
    ResultSet read(String query, String search);
    
}
