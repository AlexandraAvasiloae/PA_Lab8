package optional.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class Director {

    private int id;
    private String name;
    private int id_movie;

    @Override
    public String toString() {
        return "Tables.Director{" +
                "id=" + id +
                ", name='" + name  +
                ", movie id='" + id_movie + '\'' +
                '}';
    }

}
