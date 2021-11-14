/*Klasa tyou service komunikująca się z bazą danych MySQL
z operacjami na tabeli z pracownikami
Author: Godziejewski Filip
 */

package com.filipprojectapp1.employeemanager.service;

import com.filipprojectapp1.employeemanager.exception.UserNotFoundException;
import com.filipprojectapp1.employeemanager.model.Employee;
import com.filipprojectapp1.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//Klasa w adnotacji service*/
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    //Konstruktor klasy przyjmujacy obiket sterujący
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id" + id + "wan mot found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
