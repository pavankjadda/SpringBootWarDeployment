package com.pj.springdatademo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "post_comment")
//@Data
public class PostComment implements Serializable
{
    private static final long serialVersionUID = -6699482776799518217L;

    @EmbeddedId
    private PostCommentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("commentId")
    private Comment comment;

    public PostComment()
    {
    }

    public PostComment(PostCommentId id, Post post, Comment comment)
    {
        this.id = id;
        this.post = post;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;
        PostComment that = (PostComment) o;
        return Objects.equals(post, that.post) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(post, comment);
    }

    @Override
    public String toString()
    {
        return "PostComment{" +
                "id=" + id +
                '}';
    }
}
