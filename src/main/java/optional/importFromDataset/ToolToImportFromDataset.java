package optional.importFromDataset;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import optional.db.Actor;
import optional.db.Director;
import optional.db.Movie;
import optional.db.Genre;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString

public class ToolToImportFromDataset {

    List<Movie> moviesList = new LinkedList<>();
    List<Genre> genreList = new LinkedList<>();
    List<Actor> actorList = new LinkedList<>();
    List<Director> directorList = new LinkedList<>();

    /**
     * this method import the movies, the genres, the actors and the directors from IMDb movies.csv
     * add each movie to the movie list
     * add each genre to the genre list
     * add each actor to the actor list
     * add each director to the director list
     */
    public void importFromDataset() {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Alexandra\\IdeaProjects\\lab8_java\\src\\main\\datasets\\IMDb movies.csv"));

            try {
                reader.readNext();
                List<String[]> movies = reader.readAll();
                movies.forEach((movieDB) -> {
                    try {

                        Movie movie = new Movie();
                        movie.setDate(movieDB[4].replaceAll("DATE", ""));
                        movie.setId(Integer.parseInt(movieDB[0].replaceAll("\\D+", "")));
                        movie.setTitle(movieDB[1]);
                        movie.setDuration((int) Double.parseDouble(movieDB[6]));
                        movie.setScore((int) Double.parseDouble(movieDB[20]));

                        moviesList.add(movie);

                        Genre genre = new Genre();
                        genre.setName(movieDB[5]);
                        genre.setId(Integer.parseInt(movieDB[0].replaceAll("\\D+", "")));

                        genreList.add(genre);

                        Actor actor = new Actor();
                        actor.setId(actorList.size());
                        String actors[]=movieDB[12].split(",",2);
                        actor.setName(actors[0]);
                        actorList.add(actor);
                        actor.setId_movie(Integer.parseInt(movieDB[0].replaceAll("\\D+", "")));

                        Director director = new Director();
                        director.setName(movieDB[9]);
                        director.setId(directorList.size());
                        director.setId_movie(Integer.parseInt(movieDB[0].replaceAll("\\D+", "")));
                        directorList.add(director);

                    } catch (IllegalArgumentException var2) {
                    }

                });
            } catch (Throwable var4) {
                try {
                    reader.close();
                } catch (Throwable var3) {
                    var4.addSuppressed(var3);
                }

                throw var4;
            }

            reader.close();
        } catch (CsvException | IOException var5) {
        }
    }

}
