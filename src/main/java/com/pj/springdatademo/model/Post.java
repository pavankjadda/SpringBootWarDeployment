package com.pj.springdatademo.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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

    @NaturalId
    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PostDetail detail;

   /* @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<PostComment> posts=new HashSet<>();*/

   @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
   @JoinTable(name = "post_tag",
           joinColumns = @JoinColumn(name = "post"),
           inverseJoinColumns = @JoinColumn(name = "tag"))
   private Set<Tag> tags=new HashSet<>();

    @Override
    public String toString()
    {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail=" + detail +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return id.equals(post.id) &&
                title.equals(post.title);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, title);
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
}
