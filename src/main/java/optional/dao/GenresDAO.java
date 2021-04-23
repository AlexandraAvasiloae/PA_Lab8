package optional.dao;

import optional.db.Database;
import optional.db.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GenresDAO implements DAO<Genre> {
    List<Genre> genres=new LinkedList<>();
    private final Database db;

    /**
     * constructor
     */
    public GenresDAO() {
        db = Database.getInstance();
        String sql = " SELECT * FROM GENRES";
        try {
            ResultSet rs = db.getStmt().executeQuery(sql);
            while (rs.next()) {
                Genre myGenre = new Genre();
                myGenre.setId(rs.getInt("ID"));
                myGenre.setName(rs.getString("name"));
                genres.add(myGenre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method find the genres by name
     * @param id- the id we are looking for
     * @return- a list of generes with the specified id
     **/
    @Override
    public List<Genre> findById(int id) {
        List<Genre> pickedMovies = new LinkedList<>();
        for (Genre g : genres) {
            if (g.getId() == id)
                pickedMovies.add(g);
        }
        return pickedMovies;
    }

    /**
     * this method find the genres by name
     * @param name- the name we are looking for
     * @return- a list of generes with the specified name
     */
    @Override
    public List<Genre> findByName(String name) {
        List<Genre> pickedGenres = new LinkedList<>();
        for (Genre g : genres) {
            if (g.getName().equals(name))
                pickedGenres.add(g);
        }
        return pickedGenres;
    }

    /**
     * this method return all the genres
     * @return
     */
    @Override
    public List<Genre> getAll() {
        return genres;
    }

    /**
     * this method insert into table the genre given as argument
     * @param genre
     */
    @Override
    public void insert(Genre genre) {
        genres.add(genre);
        String command = "INSERT INTO GENRES VALUES ( "
                + genre.getId() +","
                + "'" + genre.getName() + "')";

        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method delete from the table the genre given as argument
     * @param genre
     */
    @Override
    public void delete(Genre genre) {
        genres.remove(genre);
        String command = "DELETE FROM genres WHERE id="+genre.getId();
        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}