package optional.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@EqualsAndHashCode

public class Database {
    private Connection con = null;
    private Statement stmt;
    private String sql;
    private ResultSet rs;
    private static Database single_instance = null;

    private Database() {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ALEXANDRA", "ALEXANDRA");
            con.setAutoCommit(false);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();
        return single_instance;
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}