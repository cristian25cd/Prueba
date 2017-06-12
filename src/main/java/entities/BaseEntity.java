
package main.java.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    @Id

    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    private String name;



    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    @Override

    public boolean equals(Object obj) {

        if (this.getId() != null && ((BaseEntity) obj).getId() != null) {

            return this.getId().equals(((BaseEntity) obj).getId());

        }

        return super.equals(obj);

    }



    @Override

    public int hashCode() {

        if (this.getId() != null) {

            return this.getId().hashCode();

        }

        return super.hashCode();

    }

}