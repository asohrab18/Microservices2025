package com.learning.utils;

public final class StudentsManagementContants {
	
	private StudentsManagementContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;
	
	/** Messages */
	public static final String DATA_ABSENT = "data is not present.";
	public static final String DATA_DELETED = "data deleted successfully.";
	public static final String DATA_NOT_UPDATED = "data not updated.";
	public static final String DATA_PRESENT = "data already exists for the given Id.";
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String DATA_UPDATED = "data updated successfully.";
	public static final String ID_GREATER_THAN_ZERO = "Id greater than zero is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";
	public static final String NAME_REQUIRED = "name is required.";
	
	/** QUERIES */
	public static final String STUDENTS_SELECT_BY_IDS_QUERY = "SELECT s FROM Student s WHERE s.id IN :ids";
	public static final String STUDENTS_SELECT_BY_NAME_QUERY = "SELECT s FROM Student s WHERE s.name = :name ORDER BY s.name DESC";
	public static final String STUDENTS_UPDATE_QUERY = "UPDATE Student s SET s.name = :name WHERE s.id = :id";
	
	/** OTHERS */
	public static final String ID = "id";
	public static final String IDS = "ids";
	public static final String NAME = "name";
	public static final String PATH_VARIABLE_ID = "{id}";
	public static final String PATH_VARIABLE_IDS = "{ids}";
	public static final String PATH_VARIABLE_NAME = "{name}";
	public static final String SLASH = "/";
	public static final String STUDENTS = "students";
	public static final String SLASH_ID = SLASH + ID + SLASH;
	public static final String SLASH_IDS = SLASH + IDS + SLASH;;
	public static final String SLASH_NAME = SLASH + NAME + SLASH;;
	public static final String URL_ID_PATH = SLASH_ID + PATH_VARIABLE_ID;
	public static final String URL_IDS_PATH = SLASH_IDS + PATH_VARIABLE_IDS;
	public static final String URL_NAME_PATH = SLASH_NAME + PATH_VARIABLE_NAME;
}