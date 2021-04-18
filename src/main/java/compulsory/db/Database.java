package compulsory.db;

import java.sql.*;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private Connection con = null;
    private Statement stmt;
    private String sql;
    private ResultSet rs;
    private static Database single_instance = null;

    /**
     * constructor
     * connecting to the database
     */
    private Database() {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ALEXANDRA", "ALEXANDRA");
            con.setAutoCommit(false);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a singleton class
     * @return
     */
    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();
        return single_instance;
    }

    /**
     * when you want to disconnect from the database
     */
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method executes the query "SELECT * FROM MOVIES"
     * @return
     */
    public List<Movie> getMovies() {
        List<Movie> movies = new LinkedList<>();
        sql = " SELECT * FROM MOVIES";
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie myMovie = new Movie();
                myMovie.setId(rs.getInt("ID"));
                myMovie.setTitle(rs.getString("title"));
                myMovie.setDate(rs.getString("release_date"));
                myMovie.setDuration(rs.getInt("duration"));
                myMovie.setScore(rs.getInt("score"));
                movies.add(myMovie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    /**
     * this method executes the query "SELECT * FROM GENRES"
     * @return
     */
    public List<Genre> getGenres() {
        List<Genre> genres = new LinkedList<>();
        sql = " SELECT * FROM GENRES";
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Genre myGenre = new Genre();
                myGenre.setId(rs.getInt("ID"));
                myGenre.setName(rs.getString("name"));
                genres.add(myGenre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }

    /**
     * updates the database after new changes
     */
    public void commit() {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method execute the sql query
     * @param command
     */
    public void executeCommand(String command) {
        try {
            stmt.execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}