package com.abc.management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="programme")
public class programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pid")
    private long pid;

    @Column(name="name")
    private String name;

    @Column(name="duration")
    private String duration;

    @Column(name="cost")
    private Double cost;
}
