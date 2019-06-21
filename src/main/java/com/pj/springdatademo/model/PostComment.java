package com.pj.springdatademo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "post_comment")
@Data
public class PostComment implements Serializable
{
    private static final long serialVersionUID = -6699482776799518217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","posts"})
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","comments"})
    private Comment comment;

    @Override
    public String toString()
    {
        return "PostComment{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PostComment that = (PostComment) o;
        return getPost().equals(that.getPost()) &&
                getComment().equals(that.getComment());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getPost(), getComment());
    }
}
