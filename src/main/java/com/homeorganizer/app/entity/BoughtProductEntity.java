package com.homeorganizer.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BoughtProducts")
public class BoughtProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private ProductEntity product;
    @OneToOne
    private UserEntity user;
    @OneToOne
    private GroupEntity group;
}
