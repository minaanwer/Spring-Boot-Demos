package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SCEmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> { }