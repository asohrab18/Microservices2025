package com.learning.service;

import java.util.List;
import com.learning.model.Student;
import com.learning.model.StudentsInfo;

public interface StudentsManagementService {

	Student getStudent(int id) throws Exception;

	StudentsInfo getStudents() throws Exception;

	StudentsInfo getStudents(String name) throws Exception;

	StudentsInfo getStudents(List<Integer> ids) throws Exception;

	String deleteStudent(int id) throws Exception;

	String deleteStudents() throws Exception;

	Student createStudent(Student student) throws Exception;

	Student updateStudent(Student student) throws Exception;
}
