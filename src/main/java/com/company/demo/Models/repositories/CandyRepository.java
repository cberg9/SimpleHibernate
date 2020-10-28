package com.company.demo.Models.repositories;

import com.company.demo.Models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {

}
