package com.learning.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.helper.StudentsManagementHelper;
import com.learning.model.Student;
import com.learning.model.StudentsInfo;

@Service
public class StudentsManagementServiceImpl implements StudentsManagementService {

	@Autowired
	private StudentsManagementHelper helper;

	@Override
	public Student getStudent(int id) throws Exception {
		return helper.getStudent(id);
	}

	@Override
	public StudentsInfo getStudents() throws Exception {
		return helper.getStudents();
	}

	@Override
	public StudentsInfo getStudents(String name) throws Exception {
		return helper.getStudents(name);
	}

	@Override
	public String deleteStudent(int id) throws Exception {
		return helper.deleteStudent(id);
	}

	@Override
	public String deleteStudents() throws Exception {
		return helper.deleteStudents();
	}

	@Override
	public Student createStudent(Student student) throws Exception {
		return helper.createStudent(student);
	}

	@Override
	public Student updateStudent(Student student) throws Exception {
		return helper.updateStudent(student);
	}

	@Override
	public StudentsInfo getStudents(List<Integer> ids) throws Exception {
		return helper.getStudents(ids);
	}
}
