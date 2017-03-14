package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norabbit on 14/03/17.
 */
public class JdbcPostRepository implements PostRepository{

    private DataSource dataSource;

    public JdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /*Recupére infos dans la table*/
    public List<Post> findAll()
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
    public void save(Post post) {
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


}
