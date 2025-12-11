package com.learning.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.UnprocessableException;
import com.learning.model.Student;
import com.learning.model.StudentsInfo;
import com.learning.repository.StudentsManagementRepo;
import com.learning.utils.StudentsManagementContants;

@Component
public class StudentsManagementHelper {

	private static final Logger LOG = LoggerFactory.getLogger(StudentsManagementHelper.class);

	@Autowired
	private StudentsManagementRepo repo;

	public StudentsInfo getStudents() throws Exception {
		StudentsInfo studentsInfo = new StudentsInfo();
		List<Student> students = repo.findAll();
		Optional<List<Student>> opt = Optional.ofNullable(students);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			studentsInfo.setStudents(new ArrayList<Student>());
			studentsInfo.setTotalStudents(StudentsManagementContants.ZERO);
			return studentsInfo;
		}
		studentsInfo.setStudents(students);
		studentsInfo.setTotalStudents(students.size());
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return studentsInfo;
	}

	public StudentsInfo getStudents(String name) throws Exception {
		if (StringUtils.isBlank(name)) {
			LOG.info(StudentsManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(StudentsManagementContants.DATA_REQUIRED);
		}
		StudentsInfo studentsInfo = new StudentsInfo();
		List<Student> students = repo.findByName(name);
		Optional<List<Student>> opt = Optional.ofNullable(students);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			studentsInfo.setStudents(new ArrayList<Student>());
			studentsInfo.setTotalStudents(StudentsManagementContants.ZERO);
			return studentsInfo;
		}
		studentsInfo.setStudents(students);
		studentsInfo.setTotalStudents(students.size());
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return studentsInfo;
	}

	public StudentsInfo getStudents(List<Integer> ids) throws Exception {
		Optional<List<Integer>> optIds = Optional.ofNullable(ids);
		if (!optIds.isPresent() || optIds.get().isEmpty()) {
			LOG.info(StudentsManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(StudentsManagementContants.DATA_REQUIRED);
		}
		StudentsInfo studentsInfo = new StudentsInfo();
		List<Student> students = repo.findByIds(ids);
		Optional<List<Student>> opt = Optional.ofNullable(students);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			studentsInfo.setStudents(new ArrayList<Student>());
			studentsInfo.setTotalStudents(StudentsManagementContants.ZERO);
			return studentsInfo;
		}
		studentsInfo.setStudents(students);
		studentsInfo.setTotalStudents(students.size());
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return studentsInfo;
	}

	public Student getStudent(int id) throws Exception {
		if (id == StudentsManagementContants.ZERO) {
			LOG.info(StudentsManagementContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(StudentsManagementContants.ID_GREATER_THAN_ZERO);
		}
		Optional<Student> student = repo.findById(id);
		if (!student.isPresent()) {
			LOG.info(StudentsManagementContants.DATA_ABSENT);
			throw new UnprocessableException(StudentsManagementContants.DATA_ABSENT);
		}
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return student.get();
	}

	public String deleteStudent(int id) throws Exception {
		if (id == StudentsManagementContants.ZERO) {
			LOG.info(StudentsManagementContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(StudentsManagementContants.ID_GREATER_THAN_ZERO);
		}
		Optional<Student> student = repo.findById(id);
		if (!student.isPresent()) {
			LOG.info(StudentsManagementContants.DATA_ABSENT);
			throw new UnprocessableException(StudentsManagementContants.DATA_ABSENT);
		}
		repo.delete(student.get());
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return StudentsManagementContants.DATA_DELETED;
	}

	public String deleteStudents() throws Exception {
		long count = repo.count();
		if (count == StudentsManagementContants.ZERO) {
			LOG.info(StudentsManagementContants.DATA_ABSENT);
			throw new UnprocessableException(StudentsManagementContants.DATA_ABSENT);
		}
		repo.deleteAll();
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return StudentsManagementContants.DATA_DELETED;
	}

	public Student createStudent(Student student) throws Exception {
		if (student == null) {
			LOG.info(StudentsManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(StudentsManagementContants.DATA_REQUIRED);
		}
		student = repo.save(student);
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return student;
	}

	public Student updateStudent(Student student) throws Exception {
		if (student == null) {
			LOG.info(StudentsManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(StudentsManagementContants.DATA_REQUIRED);
		}
		int id = student.getId();
		String name = student.getName();
		if (id == StudentsManagementContants.ZERO) {
			LOG.info(StudentsManagementContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(StudentsManagementContants.ID_GREATER_THAN_ZERO);
		}
		if (StringUtils.isBlank(name)) {
			LOG.info(StudentsManagementContants.NAME_REQUIRED);
			throw new MissingRequiredDataException(StudentsManagementContants.NAME_REQUIRED);
		}
		boolean exists = repo.existsById(id);
		if (!exists) {
			LOG.info(StudentsManagementContants.DATA_ABSENT);
			throw new UnprocessableException(StudentsManagementContants.DATA_ABSENT);
		}
		repo.update(id, name);
		Optional<Student> studentOpt = repo.findById(id);
		LOG.info(StudentsManagementContants.MSG_SUCCESSFUL);
		return studentOpt.get();
	}
}