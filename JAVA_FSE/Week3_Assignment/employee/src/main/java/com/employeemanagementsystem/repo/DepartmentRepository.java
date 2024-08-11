package com.employeemanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.entity.Department;
import java.util.List;



@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    // Named Queries
    List<Department> findByName(@Param("name") String name);
}
