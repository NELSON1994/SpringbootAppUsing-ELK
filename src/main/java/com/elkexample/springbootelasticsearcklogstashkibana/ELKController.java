package com.elkexample.springbootelasticsearcklogstashkibana;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ELKController {

    Employee employee=new Employee("Nelson OO","IT");
    Employee employee1=new Employee("Moses VV","WEB");
    Employee employee2=new Employee("Vincent WW","HOSPITALITY");
    Employee employee3=new Employee("Arnold TT","ADMIN");
    Employee employee4=new Employee("Shirleen SS","ENGINEERING");

@GetMapping("/getAll")
    public List<Employee> getEmployee(){
    log.info("+++++++++++++++++ fetching all employees");
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        log.info("+++++++++++++  GETTING ALL EMPLOYEES");
        return new ArrayList<>(employeeList);
    }

}
