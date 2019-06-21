package com.pj.springdatademo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
@Data
@EqualsAndHashCode(exclude={"comments"})
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
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","post","comment"})
    private Set<PostComment> comments=new HashSet<>();

    @Override
    public String toString()
    {
        return "Comment{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", content='" + content + '\'' +
                '}';
    }

}

