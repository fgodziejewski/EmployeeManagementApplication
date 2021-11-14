/*
Klasa z zestawem „mechanizmów” służących do interakcji,
 zestaw metod bez ich implementacji (bez kodu definiującego zachowanie metody)1.
 Właściwa implementacja metod danego interfejsu znajduje się w klasie implementującej dany interfejs.
 */
package com.filipprojectapp1.employeemanager.repo;

import com.filipprojectapp1.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //usuwam pracownika
    void deleteEmployeeById(Long id);

    //Wyszukuje pracownika po jego identyfikatorze
    Optional<Employee> findEmployeeById(Long id); // nie moge zwrócic na typ Employee bo moze takiego id nie być i musi obsłużyć błąd
}
