package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
//import java.lang.annotation.Repeatable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norabbit on 14/03/17.
 * Connexion  BDD 
 */
@Repository //ou @component
@Transactional
public class JpaPostRepository implements PostRepository{


    @PersistenceContext
    private EntityManager entityManager;

    public JpaPostRepository() {}

    public void save(Post post)
    {
        entityManager.persist(post);                //post recupre ID
    }

    public List<Post> findAll()
    {
        String qlString = "SELECT p FROM Post p";
        Query query = entityManager.createQuery(qlString);
        return query.getResultList();
    }

    /*private DataSource dataSource;

    public JpaPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/


    /*Recupére infos dans la table  */
  /*  public List<Post> findAll()
    {
        List<Post> db = new ArrayList<Post>();
        try
        {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();             //créer statement (pas besoin prepa car on met pas valeur)
            ResultSet resultSet = statement.executeQuery("SELECT CONTENT FROM POST");

            while (resultSet.next())            //donne prochain element de la table
            {
                Post p = new Post(resultSet.getString("CONTENT"));
                db.add(p);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return db;
    }

    /*Insertion données (posts) dans la table*/
  /*  public void save(Post post) {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
*/

}
