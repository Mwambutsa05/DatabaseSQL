package CRUDDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Student+Management+System";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Ineza2005";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
