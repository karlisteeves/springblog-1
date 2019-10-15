package com.codeup.springblog.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Posts must have a title")
    @Size(min = 4, message = "A title must be at least 4 characters.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Posts must have a description")
    @Size(min = 50, message = "The post must be at least 50 characters.")
    @Column(length = 10000)
    private String body;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Post() {

    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
