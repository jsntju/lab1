package com.polytech.business;

/**
 * Created by norabbit on 13/03/17.
 */
public class Post {


    @Override
    public String toString() {
        return '{' + content +
                '}';
    }

    private String content;

    public Post(String content) {
        this.content = content;
    }
    public Post() {
        this.content ="Commentaire par default";
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
