package com.runa.springmvc.entities.developer;

import com.runa.springmvc.entities.user.User;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NamedEntityGraph(name = "Developer.users",
attributeNodes = @NamedAttributeNode("users")
)
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "developer")
    private List<User> users = new ArrayList<>();

}