package com.example.exercise.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;

    @Column(name="`year`")
    private int year;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car(){

    }

    public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner){
        super();
        this.brand=brand;
        this.model=model;
        this.color=color;
        this.registerNumber=registerNumber;
        this.year=year;
        this.price=price;
        this.owner=owner;
    }
}
