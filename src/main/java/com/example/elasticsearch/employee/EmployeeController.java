package com.example.elasticsearch.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.createEmployee(employee);
    }


    @GetMapping("/employees/{id}")
    public Employee readEmployeesById(@PathVariable("id") String id)
    {
        return this.employeeService.readEmployeeById(id);
    }


    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") String id,
                                   @RequestBody Employee employee)
    {
        return this.employeeService.updateEmployee(id, employee);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String id)
    {
        this.employeeService.deleteEmployee(id);
    }
}
