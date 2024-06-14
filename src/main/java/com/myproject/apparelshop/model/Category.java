package com.myproject.apparelshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity //applied to entity class( Typically an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.)
@Table(name="category") //name of the table represented
@Data //for getters and setters
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name= "category_name")
    private String categoryName;

}
