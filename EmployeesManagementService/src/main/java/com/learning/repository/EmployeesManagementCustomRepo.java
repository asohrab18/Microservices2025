package com.learning.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.NotFoundException;
import com.learning.model.Employee;
import com.learning.utils.EmployeesManagementContants;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional
public class EmployeesManagementCustomRepo {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeesManagementCustomRepo.class);

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesV2(Employee emp, String sortBy, String sortType) {
		int id = EmployeesManagementContants.ZERO;
		double salary = EmployeesManagementContants.ZERO;
		String name = null;
		String city = null;
		String state = null;
		String country = null;
		if (emp != null) {
			id = emp.getId();
			salary = emp.getSalary();
			name = emp.getName();
			city = emp.getCity();
			state = emp.getState();
			country = emp.getCountry();
		}
		StringBuilder sbd = new StringBuilder();
		sbd.append("SELECT e FROM Employee e WHERE e.id > 0 ");

		if (id != EmployeesManagementContants.ZERO) {
			sbd.append(" AND e.id = :id");
		}
		if (salary != EmployeesManagementContants.ZERO) {
			sbd.append(" AND e.salary = :salary");
		}
		if (StringUtils.isNotBlank(name)) {
			sbd.append(" AND e.name = :name");
		}
		if (StringUtils.isNotBlank(city)) {
			sbd.append(" AND e.city = :city");
		}
		if (StringUtils.isNotBlank(state)) {
			sbd.append(" AND e.state = :state");
		}
		if (StringUtils.isNotBlank(country)) {
			sbd.append(" AND e.country = :country");
		}
		if (StringUtils.isNotBlank(sortBy)) {
			if (sortBy.equals("id")) {
				sbd.append(" ORDER BY e.id");
			}
			if (sortBy.equals("salary")) {
				sbd.append(" ORDER BY e.salary");
			}
			if (sortBy.equals("name")) {
				sbd.append(" ORDER BY e.name");
			}
			if (sortBy.equals("city")) {
				sbd.append(" ORDER BY e.city");
			}
			if (sortBy.equals("state")) {
				sbd.append(" ORDER BY e.state");
			}
			if (sortBy.equals("country")) {
				sbd.append(" ORDER BY e.country");
			}
			if (StringUtils.isNotBlank(sortType) && sortType.equals("desc")) {
				sbd.append(" DESC");
			} else {
				sbd.append(" ASC");
			}
		}
		String hql = sbd.toString();
		Query query = entityManager.createQuery(hql, Employee.class);
		if (id != EmployeesManagementContants.ZERO) {
			query.setParameter("id", id);
		}
		if (salary != EmployeesManagementContants.ZERO) {
			query.setParameter("salary", salary);
		}
		if (StringUtils.isNotBlank(name)) {
			name = name.trim();
			query.setParameter("name", name);
		}
		if (StringUtils.isNotBlank(city)) {
			city = city.trim();
			query.setParameter("city", city);
		}
		if (StringUtils.isNotBlank(state)) {
			state = state.trim();
			query.setParameter("state", state);
		}
		if (StringUtils.isNotBlank(country)) {
			country = country.trim();
			query.setParameter("country", country);
		}
		List<Employee> employees = (ArrayList<Employee>) query.getResultList();
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return employees;
	}

	public String updateEmployee(Employee emp) throws Exception {
		int id = emp.getId();
		double salary = emp.getSalary();
		String name = emp.getName();
		String city = emp.getCity();
		String state = emp.getState();
		String country = emp.getCountry();
		String result = null;
		boolean update = false;
		if (id == EmployeesManagementContants.ZERO) {
			LOG.info(EmployeesManagementContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(EmployeesManagementContants.ID_GREATER_THAN_ZERO);
		}
		StringBuilder sbd = new StringBuilder();
		sbd.append("UPDATE Employee e SET e.id = :id");

		if (salary != EmployeesManagementContants.ZERO) {
			update = true;
			sbd.append(", e.salary = :salary");
		}
		if (StringUtils.isNotBlank(name)) {
			update = true;
			sbd.append(", e.name = :name");
		}
		if (StringUtils.isNotBlank(city)) {
			update = true;
			sbd.append(", e.city = :city");
		}
		if (StringUtils.isNotBlank(state)) {
			update = true;
			sbd.append(", e.state = :state");
		}
		if (StringUtils.isNotBlank(country)) {
			update = true;
			sbd.append(", e.country = :country");
		}
		if (!update) {
			LOG.info(EmployeesManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(EmployeesManagementContants.DATA_REQUIRED);
		}
		sbd.append(" WHERE e.id = :id");
		String hql = sbd.toString();
		Query query = entityManager.createQuery(hql);

		query.setParameter("id", id);
		if (salary != EmployeesManagementContants.ZERO) {
			query.setParameter("salary", salary);
		}
		if (StringUtils.isNotBlank(name)) {
			name = name.trim();
			query.setParameter("name", name);
		}
		if (StringUtils.isNotBlank(city)) {
			city = city.trim();
			query.setParameter("city", city);
		}
		if (StringUtils.isNotBlank(state)) {
			state = state.trim();
			query.setParameter("state", state);
		}
		if (StringUtils.isNotBlank(country)) {
			country = country.trim();
			query.setParameter("country", country);
		}
		int count = query.executeUpdate();
		if (count > EmployeesManagementContants.ZERO) {
			result = EmployeesManagementContants.DATA_UPDATED;
		} else {
			LOG.info(EmployeesManagementContants.DATA_NOT_UPDATED);
			throw new NotFoundException(EmployeesManagementContants.DATA_NOT_UPDATED);
		}
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return result;
	}
}