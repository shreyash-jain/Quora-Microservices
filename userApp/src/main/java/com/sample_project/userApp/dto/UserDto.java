package com.sample_project.userApp.dto;

import com.sample_project.userApp.model.Address;
import com.sample_project.userApp.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {
    Long id;
    String name;
    String userName;
    String email;
    Address address;
    String phone;
    Company company;
}
