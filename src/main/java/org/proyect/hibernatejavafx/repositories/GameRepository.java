package org.proyect.hibernatejavafx.repositories;

import org.hibernate.Session;
import org.proyect.hibernatejavafx.HibernateUtil;
import org.proyect.hibernatejavafx.entities.Game;
import java.util.List;


public class GameRepository {
    private Session session; //Create a global session

    /**
     * Create Hibernate Session
     */
    public GameRepository(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Insert an object Match on the database.
     * @param game object (without id, if not it will update instead).
     */
    public void insert(Game game){
        session.beginTransaction();
        session.persist(game);
        session.getTransaction().commit();
    }

    /**
     * Modify a match object on the database.
     * @param game object.
     */
    public void update(Game game){
        session.beginTransaction();
        session.merge(game);
        session.getTransaction().commit();
    }

    /**
     * Returns a Match object by primary key.
     * @param id primary key.
     * @return match object.
     */
    public Game findById(Long id){
        return session.find(Game.class, id);
    }

    /**
     * Deletes a Match from database.
     * @param game object.
     */
    public void delete(Game game){
        session.beginTransaction();
        session.remove(game);
        session.getTransaction().commit();
    }

    /**
     * Search for all Match objects.
     * @return List of Match.
     */
    public List<Game> findAll(){
        return session.createQuery("Select g From Game g", Game.class).getResultList();
    }
}
