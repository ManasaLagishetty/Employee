package com.evoke.employee.repository;

import com.evoke.employee.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies,Long> {
}
