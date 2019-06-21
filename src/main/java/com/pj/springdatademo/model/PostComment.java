package com.pj.springdatademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_comment")
@Data
public class PostComment implements Serializable
{
    private static final long serialVersionUID = -6359823086901173857L;

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private PostDetails postDetails;

    @Column(name = "comment")
    private String comment;
}
