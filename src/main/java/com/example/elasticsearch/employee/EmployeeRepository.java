package com.example.elasticsearch.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findBySalaryBetween(Long startingSalary, Long endingSalary);

    @Query("{\"match\": {\"salary\": {\"query\": \"?0\"}}}")
    Page<Employee> findBySalary(Long salary);

}
