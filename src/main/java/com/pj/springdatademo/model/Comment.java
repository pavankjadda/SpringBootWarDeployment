package com.pj.springdatademo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "comment")
@Data
public class Comment  implements Serializable
{
    private static final long serialVersionUID = -6699482774799518217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private Set<PostComment> posts=new HashSet<>();


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comment comment = (Comment) o;
        return getId().equals(comment.getId()) &&
                Objects.equals(getContent(), comment.getContent());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getContent());
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn)
    {
        this.createdOn = createdOn;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Set<PostComment> getPosts()
    {
        return posts;
    }

    public void setPosts(Set<PostComment> posts)
    {
        this.posts = posts;
    }
}
