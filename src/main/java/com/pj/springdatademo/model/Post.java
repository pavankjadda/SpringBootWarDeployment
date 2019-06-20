package com.pj.springdatademo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Post")
@Table(name = "post")
//@Data
public class Post implements Serializable
{
    private static final long serialVersionUID = -6698422774799518217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PostDetail detail;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<PostComment> postComments=new HashSet<>();

    @Override
    public String toString()
    {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public PostDetail getDetail()
    {
        return detail;
    }

    public void setDetail(PostDetail detail)
    {
        this.detail = detail;
    }

    public Set<PostComment> getPostComments()
    {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments)
    {
        this.postComments = postComments;
    }
}
