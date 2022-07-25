package com.homeorganizer.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shopping_list")
public class ShoppingListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private GroupEntity assignedGroup;
    @OneToMany
    private List<ProductEntity> productsList = new ArrayList<>();
    @OneToMany
    private List<BoughtProductEntity> boughtProducts = new ArrayList<>();
}
