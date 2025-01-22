package org.example.generique.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("entitygenerique")
public class EntityGenerique {

    @Id
    private int id;
    private String name;
    private double age;

    public EntityGenerique() {}

    public EntityGenerique(String name, double age) {
        this.name = name;
        this.age = age;
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
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }


}
