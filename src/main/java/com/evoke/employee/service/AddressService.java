package com.evoke.employee.service;

import com.evoke.employee.exceptions.ResourceNotFoundException;
import com.evoke.employee.model.Address;
import com.evoke.employee.model.Employee;
import com.evoke.employee.repository.AddressRepository;
import com.evoke.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    public Address save(Address address) {
       Optional<Employee> employee= employeeRepository.findById(address.getEmployeeId());
        if(employee.isPresent()){
            address.setEmployee(employee.get());
            return addressRepository.save(address);
        }else {
           throw new ResourceNotFoundException("Employee not found with employeeId: " + address.getEmployeeId());
        }
    }

    public List<Address> employeeAddress() {
        return  addressRepository.findAll();
    }
}
