package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public Connection connection;
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            System.out.println("JDBC Driver tidak ditemukan");
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/resto_db";
            connection = DriverManager.getConnection(url, "root", "");
        }
        catch(SQLException e) {
            System.out.println("Koneksi ke DB Gagal");
        }
        return connection;
    }
    public static void main(String[]args) {
        java.sql.Connection DB = new Database().connect();
    }
}
