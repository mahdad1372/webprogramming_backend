package com.example.web_programming_project.repositories;

import com.example.web_programming_project.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value="SELECT * FROM Users a WHERE a.email=?1", nativeQuery=true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM Users" , nativeQuery = true)
    public List<User> getAllUsers();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Users WHERE id = :id", nativeQuery = true)
    public void deleteUsersById(Integer id);
    @Query(value="SELECT * FROM Users a WHERE a.username=?1 AND a.email=?2", nativeQuery=true)
    List<User> fetchallfromcustomerswithName(String first_name,String email);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Users (full_name,email,password,role) values (?1,?2,?3,?4)",
            nativeQuery = true)
    void addUser(String fullName,String email,String password,String role);

}

