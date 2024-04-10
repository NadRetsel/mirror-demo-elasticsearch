package com.example.elasticsearch.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee)
    {
        return this.employeeRepository.save(employee);
    }

    public Employee readEmployeeById(String id)
    {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found. Failed to fetch."));
    }

    public Employee updateEmployee(String id, Employee newEmployee)
    {
        Employee oldEmployee = readEmployeeById(id);
        oldEmployee.update(newEmployee);
        return this.employeeRepository.save(oldEmployee);
    }

    public void deleteEmployee(String id)
    {
        this.employeeRepository.deleteById(id);
    }



    /* CRUD operations using 'elasticsearchOperations'

    private final ElasticsearchOperations elasticsearchOperations;


    public Employee createEmployee(Employee employee)
    {
        return this.elasticsearchOperations.save(employee);
    }

    public Employee readEmployeeById(String id)
    {
        return this.elasticsearchOperations.findById(id, Employee.class);
    }

    public Employee updateEmployee(String newName, String id)
    {
        Employee oldEmployee = readEmployeeById(id);
        oldEmployee.setName(newName);
        return this.employeeRepository.save(oldEmployee);
    }

    public Employee deleteEmployee(String id)
    {
        return this.employeeRepository.delete(id, Employee.class);
    }



    public List<Employee> readEmployeesBySalaryRange(int startingSalary, int endingSalary)
    {
        Criteria criteria = new Criteria("salary")
                .greaterThan(startingSalary)
                .lessThan(endingSalary);

        Query query = new CriteriaQuery(criteria);
        SearchHits<Employee> searchHits = elasticsearchOperations.search(query, Employee.class);

        List<Employee> employeeList = searchHits.getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .toList();

        return employeeList;
    }


    public List<Employee> readEmployeesByName(String name)
    {
        Query query = new StringQuery("{ \"match\": { \"name\": { \"query\": \"" + name + "\" } } } ");

        SearchHits<Employee> searchHits = elasticsearchOperations.search(query, Employee.class);

        List<Employee> employeeList = searchHits.getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .toList();

        return employeeList;
    }

     */

}
