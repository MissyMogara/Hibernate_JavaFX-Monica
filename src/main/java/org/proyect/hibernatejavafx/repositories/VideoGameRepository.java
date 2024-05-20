package org.proyect.hibernatejavafx.repositories;

import org.hibernate.Session;
import org.proyect.hibernatejavafx.HibernateUtil;
import org.proyect.hibernatejavafx.entities.VideoGame;
import java.util.List;

public class VideoGameRepository {
    private Session session; //Create a global session

    /**
     * Create Hibernate Session
     */
    public VideoGameRepository(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Insert an object Game on the database.
     * @param videoGame object (without id, if not it will update instead).
     */
    public void insert(VideoGame videoGame){
        session.beginTransaction();
        session.merge(videoGame);
        session.getTransaction().commit();
    }

    /**
     * Modify a game object on the database.
     * @param videoGame object.
     */
    public void update(VideoGame videoGame){
        session.beginTransaction();
        session.merge(videoGame);
        session.getTransaction().commit();
    }

    /**
     * Returns a game object by primary key.
     * @param id primary key.
     * @return game object.
     */
    public VideoGame findById(Long id){
        return session.find(VideoGame.class, id);
    }

    /**
     * Deletes a game from database.
     * @param videoGame object.
     */
    public void delete(VideoGame videoGame){
        session.beginTransaction();
        session.remove(videoGame);
        session.getTransaction().commit();
    }

    /**
     * Search for all Game objects.
     * @return List of Game.
     */
    public List<VideoGame> findAll(){
        return session.createQuery("Select v From VideoGame v", VideoGame.class).getResultList();
    }
}
