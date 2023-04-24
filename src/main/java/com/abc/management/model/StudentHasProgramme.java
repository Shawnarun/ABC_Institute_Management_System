package com.abc.management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="StudentHasProgramme")
public class StudentHasProgramme {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SPid")
    private long SPid;

    @Column(name="sid")
    private long sid;

    @Column(name="pid")
    private long pid;

    @Column(name="registerDate")
    private String registerDate;
}
