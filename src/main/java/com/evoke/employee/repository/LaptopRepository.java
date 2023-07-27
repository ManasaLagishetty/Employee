package com.evoke.employee.repository;

import com.evoke.employee.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository  extends JpaRepository<Laptop,Long> {
}
