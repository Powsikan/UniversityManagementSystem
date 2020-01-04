
package repository;

import java.sql.ResultSet;

public interface Repository {
    ResultSet read(String query, String search);

    void userPost(String query, String username, String password);

}
