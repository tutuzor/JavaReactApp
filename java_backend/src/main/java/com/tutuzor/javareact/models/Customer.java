package com.tutuzor.javareact.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer{
    @Id @GeneratedValue private Long id;
    private String name;

    public Customer(String name){
        this.name = name;
    }

    public Customer(){}
}