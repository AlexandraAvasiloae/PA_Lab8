package compulsory.DAO;

import compulsory.db.Database;
import compulsory.db.Movie;

import java.util.LinkedList;
import java.util.List;

public class MoviesDAO implements DAO<Movie> {

    List<Movie> movies;
    private final Database db;

    public MoviesDAO() {
        db = Database.getInstance();
        movies = db.getMovies();
    }

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
        List<Movie> pickedMovies = new LinkedList<>();
        for (Movie m : movies) {
            if (m.getTitle().equals(name))
                pickedMovies.add(m);
        }
        return pickedMovies;
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

        db.executeCommand(command);
    }

    @Override
    public void delete(Movie movie) {
        movies.remove(movie);
        String command = "DELETE FROM MOVIES WHERE ID=2"  ;
        db.executeCommand(command);
    }
}