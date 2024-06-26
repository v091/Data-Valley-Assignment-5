import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDatabase {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/departments";
//my pc won't support my sql, it keeps shutting down when opened.
        String username = "vijay_747_";
        String password = "Noneofurbusiness";

        Department dept = new Department(1, "Computer Science");

        try (Connection conn = DriverManager.getConnection(dbURL, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO department(id, name) VALUES (?, ?)")) {

            preparedStatement.setInt(1, dept.getId());
            preparedStatement.setString(2, dept.getName());

            preparedStatement.executeUpdate();

            System.out.println("Department added to database: " + dept.toString());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
