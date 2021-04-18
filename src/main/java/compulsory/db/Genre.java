package compulsory.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Genre {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Tables.Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}