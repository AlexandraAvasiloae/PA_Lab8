package optional.dao;

import optional.db.Database;
import optional.db.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MoviesDAO implements DAO<Movie> {

    List<Movie> movies=new LinkedList<>();
    private final Database db;

    /**
     * constructor
     */
    public MoviesDAO() {
        db = Database.getInstance();
        String sql = " SELECT * FROM MOVIES";
        try {
            ResultSet rs = db.getStmt().executeQuery(sql);
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
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Movie> findById(int id) {
        List<Movie> pickedMovies = new LinkedList<>();
        for (Movie m : movies) {
            if (m.getId() == id)
                pickedMovies.add(m);
        }
        return pickedMovies;
    }

    @Override
    public List<Movie> findByName(String name) {


        List<Movie> movies = new LinkedList<>();
        String sql = " SELECT * FROM MOVIES  WHERE TITLE='" + name + "'" ;
        ResultSet rs;
        try {
            rs = db.getStmt().executeQuery(sql);
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

    @Override
    public List<Movie> getAll() {
        return movies;
    }

    @Override
    public void insert(Movie movie) {
        movies.add(movie);
        String command = "INSERT INTO MOVIES VALUES ( "
                + movie.getId() + ","
                + "'" + movie.getTitle() + "'"+  ","
                + "DATE " + "'" + movie.getDate() + "'" + ","
                + movie.getDuration() + ","
                + movie.getScore() + ")";

        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Movie movie) {
        movies.remove(movie);
        String command = "DELETE FROM MOVIES WHERE ID="+movie.getId();
        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}