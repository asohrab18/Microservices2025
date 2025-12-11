package com.learning.utils;

public final class EmployeesManagementContants {
	
	private EmployeesManagementContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;

	/** Messages */
	public static final String DATA_ABSENT = "data is not present.";
	public static final String DATA_DELETED = "data deleted successfully.";
	public static final String DATA_NOT_UPDATED = "data not updated.";
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String DATA_UPDATED = "data updated successfully.";
	public static final String ID_GREATER_THAN_ZERO = "Id greater than zero is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** QUERIES */
	public static final String STORED_PROCEDURE_CALL = "CALL sp_get_employees (:id, :salary, :name, :city, :state, :country)";

	/** OTHERS */
	public static final String CITY = "city";
	public static final String COUNTRY = "country";
	public static final String EMPLOYEES = "employees";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String PATH_VARIABLE_ID = "{id}";
	public static final String SALARY = "salary";
	public static final String SLASH = "/";
	public static final String STATE = "state";
	public static final String SLASH_ID = SLASH + ID + SLASH;
	public static final String URL_ID_PATH = SLASH_ID + PATH_VARIABLE_ID;
	public static final String V1 = "v1";
	public static final String V2 = "v2";
	public static final String V3 = "v3";
	public static final String SLASH_V1 = SLASH + V1;
	public static final String SLASH_V2 = SLASH + V2;
	public static final String SLASH_V3 = SLASH + V3;
}