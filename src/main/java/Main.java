import DAO.MoviesDAO;
import db.Database;
import db.Movie;

public class Main {

    public static void main(String[] args) {
        Database myDB = Database.getInstance();
        runExample();
        myDB.disconnect();
    }
    public static void runExample() {
        Database myDB = Database.getInstance();
        MoviesDAO dbMovies = new MoviesDAO();
        Movie exampleMovie = movieValue();
        dbMovies.insert(exampleMovie);

        myDB.commit();
        System.out.println("Movie table before deletion:");
        for (Movie m : myDB.getMovies()) {
            System.out.println(m);
        }
        dbMovies.delete(exampleMovie);
        myDB.commit();
        System.out.println("Movie table after deletion:");
        for (Movie m : myDB.getMovies()) {
            System.out.println(m);
        }
    }

    public static Movie movieValue() {
        Movie exampleMovie = new Movie();
        exampleMovie.setTitle("Gone with the wind");
        exampleMovie.setScore(2);
        exampleMovie.setId(2);
        exampleMovie.setDuration(100);
        exampleMovie.setDate("2000-01-01");
        return exampleMovie;
    }
}