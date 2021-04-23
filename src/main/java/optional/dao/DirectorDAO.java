package optional.dao;

import optional.db.Actor;
import optional.db.Database;
import optional.db.Director;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DirectorDAO implements DAO<Director> {


    List<Director> directors=new LinkedList<>();
    private final Database db;

    /**
     * constructor
     */
    public DirectorDAO() {
        db = Database.getInstance();
        String sql = " SELECT * FROM DIRECTORS";
        try {
            ResultSet rs = db.getStmt().executeQuery(sql);
            while (rs.next()) {
                Director myDirectors = new Director();
                myDirectors.setId(rs.getInt("ID"));
                myDirectors.setName(rs.getString("name"));
                myDirectors.setId_movie(rs.getInt("ID_MOVIE"));
                directors.add(myDirectors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method find the directors by name
     * @param id- the id we are looking for
     * @return- a list of directors with the specified id
     **/
    @Override
    public List<Director> findById(int id) {
        List<Director> pickedDirectors = new LinkedList<>();
        for (Director d : directors) {
            if (d.getId() == id)
                pickedDirectors.add(d);
        }
        return pickedDirectors;
    }

    /**
     * this method find the directors by name
     * @param name- the name we are looking for
     * @return- a list of directors with the specified name
     */
    @Override
    public List<Director> findByName(String name) {
        List<Director> pickedDirectors = new LinkedList<>();
        for (Director d : directors) {
            if (d.getName().equals(name))
                pickedDirectors.add(d);
        }
        return pickedDirectors;
    }

    /**
     * this method return all the directors
     * @return
     */
    @Override
    public List<Director> getAll() {
        return directors;
    }

    /**
     * this method insert into table the director given as argument
     * @param director
     */
    @Override
    public void insert(Director director) {
        directors.add(director);
        String command = "INSERT INTO DIRECTORS VALUES ( "
                + director.getId() + ","
                + "'" + director.getName() + "'" + ","
                + director.getId_movie() +
                ")";

        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method delete from the table the director given as argument
     * @param director
     */
    @Override
    public void delete(Director director) {
        directors.remove(director);
        String command = "DELETE FROM DIRECTORS WHERE id=" + director.getId();
        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
