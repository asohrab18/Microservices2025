package com.learning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Student;
import com.learning.model.StudentsInfo;
import com.learning.service.StudentsManagementService;
import com.learning.utils.StudentsManagementContants;

@RestController
@RequestMapping(StudentsManagementContants.STUDENTS)
public class StudentsManagementController {

	@Autowired
	private StudentsManagementService service;
	
	@GetMapping(StudentsManagementContants.URL_IDS_PATH)
	public ResponseEntity<StudentsInfo> getStudentsByIds(@PathVariable List<Integer> ids) throws Exception {
		StudentsInfo studentsInfo = service.getStudents(ids);
		return new ResponseEntity<>(studentsInfo, HttpStatus.OK);
	}
	
	@GetMapping(StudentsManagementContants.URL_NAME_PATH)
	public ResponseEntity<StudentsInfo> getStudents(@PathVariable String name) throws Exception {
		StudentsInfo studentsInfo = service.getStudents(name);
		return new ResponseEntity<>(studentsInfo, HttpStatus.OK);
	}

	@GetMapping(StudentsManagementContants.SLASH)
	public ResponseEntity<StudentsInfo> getAllStudents() throws Exception {
		StudentsInfo studentsInfo = service.getStudents();
		return new ResponseEntity<>(studentsInfo, HttpStatus.OK);
	}

	@DeleteMapping(StudentsManagementContants.SLASH)
	public ResponseEntity<String> deleteAllStudents() throws Exception {
		String deleteMessage = service.deleteStudents();
		return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	}

	@PostMapping(StudentsManagementContants.SLASH)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws Exception {
		student = service.createStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping(StudentsManagementContants.SLASH)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception {
		student = service.updateStudent(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping(StudentsManagementContants.URL_ID_PATH)
	public ResponseEntity<Student> getStudent(@PathVariable int id) throws Exception {
		Student student = service.getStudent(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping(StudentsManagementContants.URL_ID_PATH)
	public ResponseEntity<String> deleteStudent(@PathVariable int id) throws Exception {
		String deleteMessage = service.deleteStudent(id);
		return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	}
}