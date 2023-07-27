package com.evoke.employee.repository;

import com.evoke.employee.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
}
