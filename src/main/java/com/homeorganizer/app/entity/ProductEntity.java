package com.homeorganizer.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private String id;
    private String productName;
}
