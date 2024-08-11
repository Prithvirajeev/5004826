package com.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repo.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Page<Employee> getEmployeesByDepartmentId(Long departmentID,Pageable pageable){
        return employeeRepository.findByDepartmentId(departmentID,pageable);
    }
}
