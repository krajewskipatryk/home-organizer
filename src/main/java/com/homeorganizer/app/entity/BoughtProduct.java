package com.homeorganizer.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BoughtProducts")
public class BoughtProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Product product;
    @OneToOne
    private UserEntity user;
    @OneToOne
    private GroupEntity group;
}
