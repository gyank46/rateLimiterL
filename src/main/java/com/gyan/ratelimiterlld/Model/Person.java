package com.gyan.ratelimiterlld.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class Person {

//    public Person(@JsonProperty("name") String name){
//        this.name=name;
//    }

//    public Person(@JsonProperty("name") String name, @JsonProperty("token") int token){
//        this.name=name;
//        this.token=token;
//    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Column
    private int token=Integer.MIN_VALUE;
    @Column
    private String name;

    @Id
    @Column
    private String id;
}
