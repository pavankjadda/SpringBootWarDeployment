package com.pj.springdatademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @EmbeddedId
    private PostCommentId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("postId")
    @JsonIgnore
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("postId")
    @JsonIgnore
    private Comment comment;

    public PostComment()
    {
    }

    public PostComment(Post post, Comment comment)
    {
        this.post = post;
        this.comment = comment;
        this.id=new PostCommentId(post.getId(), comment.getId());
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

    public PostCommentId getId()
    {
        return id;
    }

    public void setId(PostCommentId id)
    {
        this.id = id;
    }

    public Post getPost()
    {
        return post;
    }

    public void setPost(Post post)
    {
        this.post = post;
    }

    public Comment getComment()
    {
        return comment;
    }

    public void setComment(Comment comment)
    {
        this.comment = comment;
    }
}
