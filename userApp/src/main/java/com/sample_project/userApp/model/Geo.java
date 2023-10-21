package com.sample_project.userApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String longitude;
    String latitude;

    @OneToOne
    Address address;
}
