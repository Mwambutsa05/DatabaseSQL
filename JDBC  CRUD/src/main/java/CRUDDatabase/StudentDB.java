package CRUDDatabase;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class StudentDB {

    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.connect();
            insert(conn, "Mwambutsa", "Daryce", "mwambutsadaryce@gmail.com", Date.valueOf("2005-04-15"));
            insert(conn, "Mwambutsa", "Doriane", "mwambutsadoriane@gmail.com", Date.valueOf("2006-11-30"));
            insert(conn, "Mwambutsa", "Divine", "mwambutsadivine@gmail.com", Date.valueOf("2001-01-04"));
            insert(conn, "Mwambutsa", "Daniella", "mwambutsadaniella@gmail.com", Date.valueOf("2002-09-10"));
            insert(conn, "Mwambutsa", "Denyse", "mwambutsadaniella@gmail.com", Date.valueOf("2002-09-10"));

            read(conn);

            update(conn, 1, "mwambutsadaryce", Date.valueOf("2002-08-01"));

            delete(conn, 1);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void insert (Connection conn, String first_name, String last_name, String email, Date date_of_birth ) throws SQLException {
        String sql = "INSERT INTO student (first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, first_name);
        ps.setString(2, last_name);
        ps.setString(3, email);
        ps.setDate(4, date_of_birth);
        ps.executeUpdate();
        ps.close();

    }

    public static void  read(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id" )
                    + "FirstName: " + rs.getString("first_name")
                    + "LastName: " + rs.getString("last_name")
                    + "Email: " + rs.getString("email")
                    + "DateOfBirth: " + rs.getString("date_of_birth"));
        }
        rs.close();
        stmt.close();
    }

    public static void update(Connection conn, int id, String email,Date date_of_birth) throws SQLException {
        String sql = "update student set email = ?, date_of_birth = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setDate(2, date_of_birth);
        ps.setInt(3, id);
        ps.executeUpdate();
        ps.close();
    }

    public static void delete(Connection conn, int id) throws SQLException {
        String sql = "delete from student where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
