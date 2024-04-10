package com.example.elasticsearch.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "employees", createIndex = true)
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Long, name = "salary")
    private Long salary;


    public void update(Employee newEmployee)
    {
        if(null != newEmployee.getId())     this.id = newEmployee.getId();
        if(null != newEmployee.getName())   this.name = newEmployee.getName();
        if(null != newEmployee.getSalary()) this.salary = newEmployee.getSalary();
    }

}
