package com.learning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.learning.model.Employee;
import com.learning.utils.EmployeesManagementContants;

@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	List<Employee> findByName(String name);
	List<Employee> findByCity(String city);
	List<Employee> findByState(String state);
	List<Employee> findByCountry(String country);
	List<Employee> findByNameAndCity(String name, String city);
	List<Employee> findByCityAndState(String city, String state);
	List<Employee> findByStateAndCountry(String state, String country); 
	
	@Query(value = EmployeesManagementContants.STORED_PROCEDURE_CALL, nativeQuery = true)
	List<Object[]> findEmployees(
		@Param(value = EmployeesManagementContants.ID) Integer id,
		@Param(value = EmployeesManagementContants.SALARY) Double salary,
		@Param(value = EmployeesManagementContants.NAME) String name,
		@Param(value = EmployeesManagementContants.CITY) String city,
		@Param(value = EmployeesManagementContants.STATE) String state,
		@Param(value = EmployeesManagementContants.COUNTRY) String country
	);
}
