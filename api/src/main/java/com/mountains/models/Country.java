package com.mountains.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @OneToMany
    @JoinColumn(name = "country_id")
    List<Hill> hillsList;

    public List<Hill> getHillsList() {
        return hillsList;
    }

    public void setHillsList(List<Hill> hillsList) {
        this.hillsList = hillsList;
    }

    public Country(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
