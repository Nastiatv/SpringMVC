package com.runa.springmvc.entities.user;

import com.runa.springmvc.entities.developer.Developer;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;
}