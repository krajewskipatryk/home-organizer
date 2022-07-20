package com.homeorganizer.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private GroupEntity assignedGroup;
    @OneToMany
    private List<Product> productsList = new ArrayList<>();
    @OneToMany
    private List<BoughtProduct> boughtProducts = new ArrayList<>();
}
