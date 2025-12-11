package com.learning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.learning.model.Student;
import com.learning.utils.StudentsManagementContants;

@Transactional
public interface StudentsManagementRepo extends JpaRepository<Student, Integer> {

	@Modifying
	@Query(StudentsManagementContants.STUDENTS_UPDATE_QUERY)
	void update(@Param(value = StudentsManagementContants.ID) int id, @Param(value = StudentsManagementContants.NAME) String name);
	
	
	@Query(StudentsManagementContants.STUDENTS_SELECT_BY_NAME_QUERY)
	List<Student> findByName(@Param(value = StudentsManagementContants.NAME) String name);
	
	@Query(StudentsManagementContants.STUDENTS_SELECT_BY_IDS_QUERY)
	List<Student> findByIds(@Param(value = StudentsManagementContants.IDS) List<Integer> ids);
}
