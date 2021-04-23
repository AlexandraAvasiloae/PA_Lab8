package optional;

import optional.dao.ActorsDAO;
import optional.dao.DirectorDAO;
import optional.dao.GenresDAO;
import optional.dao.MoviesDAO;
import optional.db.*;
import optional.importFromDataset.ToolToImportFromDataset;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    static final Logger log = Logger.getLogger(Main.class);

    /**
     * this method create a Movie object
     * @return
     */
    public static Movie createMovie() {

        Movie movie = new Movie();
        movie.setTitle("Dark");
        movie.setScore(2);
        movie.setId(11);
        movie.setDuration(100);
        movie.setDate("2000-01-01");
        return movie;
    }

    /**
     * this method create a Genre object
     * @return
     */
    public static Genre createGenre() {
        Genre genre = new Genre();
        genre.setId(10);
        genre.setName("Romance");
        return genre;
    }

    public static Actor createActor() {
        Actor actor = new Actor();
        actor.setId(6);
        actor.setName("Clark Gable");
        actor.setId_movie(6);
        return actor;
    }

    /**
     * this method create a Director object
     * @return
     */
    public static Director createDirector() {
        Director director = new Director();
        director.setId(6);
        director.setName("Victor Fleming");
        director.setId_movie(6);
        return director;
    }

    public static void runExample() {

        BasicConfigurator.configure();
        Database myDB = Database.getInstance();
        MoviesDAO dbMovies = new MoviesDAO();
        Movie exampleMovie = createMovie();
        dbMovies.insert(exampleMovie);

        log.info("select * from movies where name='titanic- "+ dbMovies.findByName("titanic"));

        myDB.commit();
        log.info("Movie table before deletion:");
        for (Movie m : dbMovies.getAll()) {
            log.info(m);
        }
        dbMovies.delete(exampleMovie);
        myDB.commit();
        log.info("Movie table after deletion:");
        for (Movie m : dbMovies.getAll()) {
            log.info(m);
        }

        GenresDAO dbGenres = new GenresDAO();
        Genre exampleGenre = createGenre();
        dbGenres.insert(exampleGenre);

        myDB.commit();
        log.info("Genre table before deletion:");
        for (Genre g : dbGenres.getAll()) {
            log.info(g);
        }
        dbGenres.delete(exampleGenre);
        myDB.commit();
        log.info("Genre table after deletion:");
        for (Genre g : dbGenres.getAll()) {
            log.info(g);
        }

        ActorsDAO dbActors = new ActorsDAO();
        Actor exampleActor = createActor();
        dbActors.insert(exampleActor);

        myDB.commit();
        log.info("Actor table before deletion:");
        for (Actor a : dbActors.getAll()) {
            log.info(a);
        }
        dbActors.delete(exampleActor);
        myDB.commit();
        log.info("Actor table after deletion:");
        for (Actor a : dbActors.getAll()) {
            log.info(a);
        }

        DirectorDAO dbDirector = new DirectorDAO();
        Director exampleDirector = createDirector();
        dbDirector.insert(exampleDirector);

        myDB.commit();
        log.info("Director table before deletion");
        for (Director d : dbDirector.getAll()){
            log.info(d);
        }

        dbDirector.delete(exampleDirector);
        myDB.commit();

        log.info("Director table after deletion: ");
        for (Director d : dbDirector.getAll()){
            log.info(d);
        }
    }

    /**
     * this method insert into database some movies from csv
     * for every movie inserted, the movie genre, actor and director are inserted
     */
    public static void runExampleImportFromDataset(){
        BasicConfigurator.configure();
        Database myDB = Database.getInstance();
        ToolToImportFromDataset tool = new ToolToImportFromDataset();
        tool.importFromDataset();
        MoviesDAO dbMovies = new MoviesDAO();
        GenresDAO dbGenres = new GenresDAO();
        ActorsDAO dbActors =  new ActorsDAO();
        DirectorDAO dbDirectors =  new DirectorDAO();

        for (int i =50 ;i<=53;i++){
            dbMovies.insert(tool.getMoviesList().get(i));
            myDB.commit();
            dbGenres.insert(tool.getGenreList().get(i));
            myDB.commit();
            dbActors.insert(tool.getActorList().get(i));
            myDB.commit();
            dbDirectors.insert(tool.getDirectorList().get(i));
            myDB.commit();
        }
    }

    /**
     * display all movies from db
     */
    public static void printMovies(){
        MoviesDAO dbMovies = new MoviesDAO();
        log.info("Movie table after insert some elements from dataset:");
        for (Movie m : dbMovies.getAll()) {
            log.info(m);
        }
    }

    /**
     * display all genres from db
     */
    public static void printGenres(){
        GenresDAO dbGenres = new GenresDAO();
        log.info("Genre table after insert some elements from dataset:");
        for (Genre g : dbGenres.getAll()){
            log.info(g);
        }
    }

    /**
     * display all actors from db
     */
    public static void printActors(){
        ActorsDAO dbActors =  new ActorsDAO();
        log.info("Actors table after insert some elements from dataset:");
        for(Actor a: dbActors.getAll()){
            log.info(a);
        }
    }

    /**
     * display all directors from db
     */
    public  static  void printDirectors(){
        DirectorDAO dbDirectors =  new DirectorDAO();
        log.info("Directors table after insert some elements from dataset:");
        for(Director d : dbDirectors.getAll()){
            log.info(d);
        }
    }
    public static void main(String[] args) {
        Database myDB = Database.getInstance();
        //runExample();
        runExampleImportFromDataset();
        printMovies();
        printGenres();
        printDirectors();
        printActors();
        myDB.disconnect();
    }
}