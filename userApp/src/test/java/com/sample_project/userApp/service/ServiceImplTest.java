package com.sample_project.userApp.service;

import com.sample_project.userApp.dto.UserDto;
import com.sample_project.userApp.model.Address;
import com.sample_project.userApp.model.Company;
import com.sample_project.userApp.model.Geo;
import com.sample_project.userApp.model.User;
import com.sample_project.userApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ServiceImplTest {

    private ServiceImpl serviceImplUnderTest;

    @BeforeEach
    void setUp() {
        serviceImplUnderTest = new ServiceImpl();
        serviceImplUnderTest.repository = mock(UserRepository.class);
    }

    @Test
    void testShowAll() {
        // Setup
        final List<User> expectedResult = List.of(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)));

        // Configure UserRepository.findAll(...).
        final List<User> users = List.of(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)));
        when(serviceImplUnderTest.repository.findAll()).thenReturn(users);

        // Run the test
        final List<User> result = serviceImplUnderTest.showAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testShowAll_UserRepositoryReturnsNoItems() {
        // Setup
        when(serviceImplUnderTest.repository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = serviceImplUnderTest.showAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetUserById() {
        // Setup
        final User expectedResult = new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null));

        // Configure UserRepository.findById(...).
        final Optional<User> user = Optional.of(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)));
        when(serviceImplUnderTest.repository.findById(0L)).thenReturn(user);

        // Run the test
        final User result = serviceImplUnderTest.getUserById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUserById_UserRepositoryReturnsAbsent() {
        // Setup
        final User expectedResult = new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null));
        when(serviceImplUnderTest.repository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final User result = serviceImplUnderTest.getUserById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testAddUser() {
        // Setup
        final UserDto user = new UserDto(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null),
                        new User(0L, "name", "userName", "email", null, "phone",
                                new Company(0L, "name", "location", null))), "phone",
                new Company(0L, "name", "location", new User(0L, "name", "userName", "email",
                        new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                        null)));

        // Configure UserRepository.save(...).
        final User user1 = new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null));
        when(serviceImplUnderTest.repository.save(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)))).thenReturn(user1);

        // Run the test
        final String result = serviceImplUnderTest.addUser(user);

        // Verify the results
        assertThat(result).isEqualTo("User Added!!");
        verify(serviceImplUnderTest.repository).save(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)));
    }

    @Test
    void testDeleteUser() {
        // Setup
        // Run the test
        final String result = serviceImplUnderTest.deleteUser(0L);

        // Verify the results
        assertThat(result).isEqualTo("result");
        verify(serviceImplUnderTest.repository).deleteById(0L);
    }

    @Test
    void testUpdateUser() {
        // Setup
        final UserDto inputUser = new UserDto(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null),
                        new User(0L, "name", "userName", "email", null, "phone",
                                new Company(0L, "name", "location", null))), "phone",
                new Company(0L, "name", "location", new User(0L, "name", "userName", "email",
                        new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                        null)));
        final User expectedResult = new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null));

        // Configure UserRepository.findById(...).
        final Optional<User> user = Optional.of(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)));
        when(serviceImplUnderTest.repository.findById(0L)).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user1 = new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null));
        when(serviceImplUnderTest.repository.save(new User(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                new Company(0L, "name", "location", null)))).thenReturn(user1);

        // Run the test
        final User result = serviceImplUnderTest.updateUser(0L, inputUser);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateUser_UserRepositoryFindByIdReturnsAbsent() {
        // Setup
        final UserDto inputUser = new UserDto(0L, "name", "userName", "email",
                new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null),
                        new User(0L, "name", "userName", "email", null, "phone",
                                new Company(0L, "name", "location", null))), "phone",
                new Company(0L, "name", "location", new User(0L, "name", "userName", "email",
                        new Address(0L, "street", "city", new Geo(0L, "longitude", "latitude", null), null), "phone",
                        null)));
        when(serviceImplUnderTest.repository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> serviceImplUnderTest.updateUser(0L, inputUser))
                .isInstanceOf(NullPointerException.class);
    }
}
