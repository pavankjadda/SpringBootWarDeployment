package com.pj.springdatademo.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tag")
//@Data
public class Tag implements Serializable
{
    private static final long serialVersionUID = -368617494872429790L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts=new HashSet<>();

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tag tag = (Tag) o;
        return id.equals(tag.id) &&
                name.equals(tag.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }
}
