package CRUDDatabase;

import java.sql.Connection;
import java.sql.Date;

public interface DBCrud {
    void insert(Connection conn, String first_name, String last_name, String email, Date date_of_birth );
    void read(Connection conn);
    void update(Connection conn, int id, String email,Date date_of_birth);
    void delete(Connection conn, int id);
}
