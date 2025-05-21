package CRUDDatabase;

import org.example.Main;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class MarksDB {
    public static void main(String[] args) {
        try{
            Connection conn = DBConnection.connect();

            insert(conn, 90);
            insert(conn, 70);
            insert(conn, 80);
            insert(conn, 75);

            read(conn);

            update(conn, 77, 2);
            update(conn, 98, 1);

            delete(conn, 75);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Connection conn, int marks) throws SQLException {
      String sql = "insert into marks values(?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, 90);
      pstmt.executeUpdate();
      pstmt.close();
    }

    public static void read(Connection conn) throws SQLException {
        String sql = "select * from marks";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int marks = rs.getInt("marks");
            System.out.println(marks);
        }
    }

    public static void update(Connection conn, int marks, int id) throws SQLException {
        String sql = "update marks set marks = ? where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, marks);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public static void delete(Connection conn, int marks) throws SQLException {
        String sql = "delete from marks where marks = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, marks);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
