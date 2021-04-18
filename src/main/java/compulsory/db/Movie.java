package compulsory.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode

public class Movie {

    private int id;
    private String title;
    private String date;
    private int score;
    private int duration;


    @Override
    public String toString() {
        return "Tables.Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", score=" + score +
                ", duration=" + duration +
                '}';
    }
}