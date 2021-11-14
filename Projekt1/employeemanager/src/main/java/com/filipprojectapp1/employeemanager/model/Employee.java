//Klasa która będzie odnosiła się do bazy danych
package com.filipprojectapp1.employeemanager.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable{ //transformuje ten typ klasy jako stream, bedzie wysylane jako json
   @Id // pierwsza zmienna to id tabeli
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false, updatable = false)
    private Long id;  // powyższe rzeczy dotyczą id, autoid nowe wartości automatycznie
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl; // lokalizacja pliku
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee() {}

    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    @Override
    public String toString(){
        return "Employee{" +
                "id" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

