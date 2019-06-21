package com.pj.springdatademo.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Entity
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

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PostComment> comments=new HashSet<>();


    public void addComment(Comment comment)
    {
        PostComment postComment = new PostComment(this,comment);
        comments.add(postComment);
        comment.getPosts().add(postComment);
    }

    public void removeComment(Comment comment)
    {
        for (Iterator<PostComment> iterator = comments.iterator();
                iterator.hasNext(); )
        {
            PostComment postComment = iterator.next();

            if (postComment.getPost().equals(this) &&
                    postComment.getComment().equals(comment))
            {
                iterator.remove();
                postComment.getComment().getPosts().remove(postComment);
                postComment.setPost(null);
                postComment.setComment(null);
            }
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return getId().equals(post.getId()) &&
                Objects.equals(getTitle(), post.getTitle());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getTitle());
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

    public Set<PostComment> getComments()
    {
        return comments;
    }

    public void setComments(Set<PostComment> comments)
    {
        this.comments = comments;
    }
}
