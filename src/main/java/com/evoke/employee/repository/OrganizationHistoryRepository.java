package com.evoke.employee.repository;

import com.evoke.employee.model.OrganizationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationHistoryRepository  extends JpaRepository<OrganizationHistory,Long> {
}
