package CRUDDatabase;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class CourseDB {
    public static void main(String[] args) {
        try{
            Connection conn = DBConnection.connect();

            insert(conn, "Mathematics", "Math" );
            insert(conn, "Computer Science", "comp" );
            insert(conn, "Economics", "Econ" );
            insert(conn, "Entreprenuership", "Ent" );
            insert(conn, "Information Technology", "IT" );


            read(conn);

            update(conn, "Cyber Security", "Cyber" , 4);

            delete(conn, 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Connection conn, String course_name, String course_description) throws SQLException{
        String sql = "INSERT INTO TABLE courses(String course_name, String course_description) VALUES (?, ? )";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, course_name);
        pst.setString(2, course_description);

         pst.executeUpdate();
         pst.close();

    }

    public static void read(Connection conn) throws SQLException{
        String sql = "SELECT * FROM courses";
        Statement pst = conn.createStatement();
        ResultSet rs = pst.executeQuery(sql);
        while(rs.next()){
            String course_name = rs.getString("course_name");
            String course_description = rs.getString("course_description");
            System.out.println(course_name + " " + course_description);
        }
    }

    public static void update(Connection conn,  String course_name, String course_description, int id) throws SQLException{
        String sql = "UPDATE TABLE courses SET course_name = ?, course_description = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, course_name);
        pst.setString(2, course_description);
        pst.setInt(3, id);
        pst.executeUpdate();
        pst.close();
    }

    public static void delete(Connection conn, int id) throws SQLException{
        String sql = "DELETE FROM courses WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
    }
}
