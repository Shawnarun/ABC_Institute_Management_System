package com.abc.management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="students")

public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sid")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="contact")
    private String contact;


}
