package com.pj.springdatademo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_comment")
@Data
@EqualsAndHashCode(exclude={"post","comment"})
public class PostComment implements Serializable
{
    private static final long serialVersionUID = -6699482776799518217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    //@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","posts"})
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    //@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","comments"})
    private Comment comment;

    @Override
    public String toString()
    {
        return "PostComment{" +
                "id=" + id +
                '}';
    }
}
