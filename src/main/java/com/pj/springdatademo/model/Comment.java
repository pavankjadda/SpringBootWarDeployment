package com.pj.springdatademo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
//@Data
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

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private Set<PostComment> postComments=new HashSet<>();

    @Override
    public String toString()
    {
        return "Comment{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", content='" + content + '\'' +
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

    public Set<PostComment> getPostComments()
    {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments)
    {
        this.postComments = postComments;
    }
}

