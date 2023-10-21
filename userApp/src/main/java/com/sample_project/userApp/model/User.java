package com.sample_project.userApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyToOne;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name = "UserDetails")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String userName;
    String email;

    //    @OneToOne(cascade = {CascadeType.ALL})
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
            Address address;
    String phone;
    //    @OneToOne(cascade = {CascadeType.ALL})
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    Company company;


}
