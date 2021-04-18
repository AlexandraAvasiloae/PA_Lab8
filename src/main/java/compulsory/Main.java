package compulsory;

import compulsory.DAO.GenresDAO;
import compulsory.DAO.MoviesDAO;
import compulsory.db.Database;
import compulsory.db.Genre;
import compulsory.db.Movie;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    static final Logger log = Logger.getLogger(Main.class);

    /**
     * this method create an instance of Movie
     * @return
     */
    public static Movie createMovie() {

        Movie movie = new Movie();
        movie.setTitle("Gone with the wind");
        movie.setScore(2);
        movie.setId(2);
        movie.setDuration(100);
        movie.setDate("2000-01-01");
        return movie;
    }

    /**
     * this method create an instance of Genre
     * @return
     */
    public static Genre createGenre(){
            Genre genre = new Genre();
            genre.setId(10);
            genre.setName("Romance");
            return genre;
    }

    /**
     * this method insert to the tables the new movie and genre
     */
    public static void runExample() {

        BasicConfigurator.configure();
        Database myDB = Database.getInstance();
        MoviesDAO dbMovies = new MoviesDAO();
        Movie exampleMovie = createMovie();
        dbMovies.insert(exampleMovie);

        myDB.commit();
        log.info("Movie table before deletion:");
        for (Movie m : myDB.getMovies()) {
            log.info(m);
        }
        dbMovies.delete(exampleMovie);
        myDB.commit();
        log.info("Movie table after deletion:");
        for (Movie m : myDB.getMovies()) {
            log.info(m);
        }

        GenresDAO dbGenres = new GenresDAO();
        Genre exampleGenre = createGenre();
        dbGenres.insert(exampleGenre);

        myDB.commit();
        log.info("Genre table before deletion:");
        for (Genre g : myDB.getGenres()) {
            log.info(g);
        }
        dbGenres.delete(exampleGenre);
        myDB.commit();
        log.info("Genre table after deletion:");
        for (Genre g : myDB.getGenres()) {
            log.info(g);
        }
    }

    public static void main(String[] args) {
        Database myDB = Database.getInstance();
        runExample();
        myDB.disconnect();
    }
}