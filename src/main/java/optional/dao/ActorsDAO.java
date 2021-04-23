package optional.dao;

import optional.db.Actor;
import optional.db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ActorsDAO implements DAO<Actor>{

    List<Actor> actors=new LinkedList<>();
    private final Database db;

    /**
     * constructor
     */
    public ActorsDAO() {
        db = Database.getInstance();
        String sql = " SELECT * FROM ACTORS";
        try {
            ResultSet rs = db.getStmt().executeQuery(sql);
            while (rs.next()) {
                Actor myActors = new Actor();
                myActors.setId(rs.getInt("ID"));
                myActors.setName(rs.getString("name"));
                myActors.setId_movie(rs.getInt("ID_MOVIE"));
                actors.add(myActors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method find the actorss by name
     * @param id- the id we are looking for
     * @return- a list of actors with the specified id
     **/
    @Override
    public List<Actor> findById(int id) {
        List<Actor> pickedActors = new LinkedList<>();
        for (Actor a : actors) {
            if (a.getId() == id)
                pickedActors.add(a);
        }
        return pickedActors;
    }

    /**
     * this method find the actors by name
     * @param name- the name we are looking for
     * @return- a list of actors with the specified name
     */
    @Override
    public List<Actor> findByName(String name) {
        List<Actor> pickedActors = new LinkedList<>();
        for (Actor a : actors) {
            if (a.getName().equals(name))
                pickedActors.add(a);
        }
        return pickedActors;
    }

    /**
     * this method return all the actors
     * @return
     */
    @Override
    public List<Actor> getAll() {
        return actors;
    }

    /**
     * this method insert into table the actor given as argument
     * @param actor
     */
    @Override
    public void insert(Actor actor) {
        actors.add(actor);
        String command = "INSERT INTO ACTORS VALUES ( "
                + actor.getId() + ","
                + "'" + actor.getName() + "'" + ","
                 + actor.getId_movie() +
                ")";

        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method delete from the table the actor given as argument
     * @param actor
     */
    @Override
    public void delete(Actor actor) {
        actors.remove(actor);
        String command = "DELETE FROM ACTORS WHERE id=" + actor.getId();
        try {
            db.getStmt().execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
