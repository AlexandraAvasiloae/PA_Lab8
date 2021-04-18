package compulsory.DAO;

import compulsory.db.Database;
import compulsory.db.Movie;

import java.util.LinkedList;
import java.util.List;

public class MoviesDAO implements DAO<Movie> {

    List<Movie> movies;
    private final Database db;

    /**
     * constructor
     */
    public MoviesDAO() {
        db = Database.getInstance();
        movies = db.getMovies();
    }
    /**
     * this method find the movies by name
     * @param id- the id we are looking for
     * @return- a list of movies with the specified id
     **/
    @Override
    public List<Movie> findById(int id) {
        List<Movie> pickedMovies = new LinkedList<>();
        for (Movie m : movies) {
            if (m.getId() == id)
                pickedMovies.add(m);
        }
        return pickedMovies;
    }

    /**
     * this method find the movies by name
     * @param name- the name we are looking for
     * @return- a list of movies with the specified name
     */
    @Override
    public List<Movie> findByName(String name) {
        List<Movie> pickedMovies = new LinkedList<>();
        for (Movie m : movies) {
            if (m.getTitle().equals(name))
                pickedMovies.add(m);
        }
        return pickedMovies;
    }

    /**
     * this method get all the movies
     * @return
     */
    @Override
    public List<Movie> getAll() {
        return movies;
    }

    /**
     * this method insert into table the movie given as argument
     * @param movie
     */
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

    /**
     * this method delete from the table the movie given as argument
     * @param movie
     */
    @Override
    public void delete(Movie movie) {
        movies.remove(movie);
        String command = "DELETE FROM MOVIES WHERE ID=2"  ;
        db.executeCommand(command);
    }
}