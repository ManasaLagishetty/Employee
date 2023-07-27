package com.evoke.employee.service;

import com.evoke.employee.model.OrganizationHistory;
import com.evoke.employee.repository.OrganizationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationHostoryService {

    @Autowired
    private OrganizationHistoryRepository organizationHistoryRepository;

    public OrganizationHistory saveOrganizationHistory(OrganizationHistory organizationHistory) {
        return organizationHistoryRepository.save(organizationHistory);
    }

    public List<OrganizationHistory> getHisotry() {
        return organizationHistoryRepository.findAll();
    }
}
