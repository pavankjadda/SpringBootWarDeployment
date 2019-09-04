package com.pj.springdatademo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostCommentId implements Serializable
{
    private static final long serialVersionUID = -5919538128653234855L;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "comment_id")
    private Long commentId;

    public PostCommentId()
    {
    }

    public PostCommentId(Long postId, Long commentId)
    {
        this.postId = postId;
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PostCommentId that = (PostCommentId) o;
        return postId.equals(that.postId) &&
                commentId.equals(that.commentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(postId, commentId);
    }

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    public Long getCommentId()
    {
        return commentId;
    }

    public void setCommentId(Long commentId)
    {
        this.commentId = commentId;
    }
}
