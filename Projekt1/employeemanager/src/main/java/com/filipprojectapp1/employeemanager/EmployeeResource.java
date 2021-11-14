/*
Klasa reprezentująca kontroler po stronie serwera
Author: Godziejewski Filip
 */

package com.filipprojectapp1.employeemanager;

import com.filipprojectapp1.employeemanager.model.Employee;
import com.filipprojectapp1.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* second adnotation give class base url */
@RestController
@RequestMapping("/employee") // to access this employee resource, all url have to have "employee" at their base
public class EmployeeResource {
    private final EmployeeService employeeService; // variable to bring in service

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //method that return all employees that I have in base
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }         //this is generic so I have to pass what type of data that's gonna be in body.

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //Postmaping, because I will be make changes in the datebase
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){ //it will return the response entity of an employee
        Employee newEmployee = employeeService.addEmployee(employee);   // expect wole employee object in json format from user
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){ //it will return the response entity of an employee
        Employee updateEmployee = employeeService.addEmployee(employee);   // expect wole employee object in json format from user
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    /* this method doest return anything so I pass question mark in ResponseEntity*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){ //it will return the response entity of an employee
        employeeService.deleteEmployee(id);   // expect wole employee object in json format from user
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
