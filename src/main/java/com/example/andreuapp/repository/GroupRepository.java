package com.example.andreuapp.repository;

import com.example.andreuapp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {


    @Query("SELECT g from Group g where g.number = :number")
    public Group findByNumberFromQuery(String number);


    Optional<Object> findByNumber(String number);

    Optional<Group> findById(Integer id);
}
