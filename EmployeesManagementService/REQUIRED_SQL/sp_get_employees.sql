CREATE PROCEDURE `sp_get_employees` (
			IN p_id INT,
			IN p_salary DOUBLE,
			IN p_name VARCHAR(100),
			IN p_city VARCHAR(100),
			IN p_state VARCHAR(100),
			IN p_country VARCHAR(100)
)
BEGIN
		SELECT id, salary, name, city, state, country FROM employee
			  WHERE (p_id IS NULL OR id = p_id)
			  AND (p_salary IS NULL OR salary = p_salary)
			  AND (p_name IS NULL OR name = p_name)
			  AND (p_city IS NULL OR city = p_city)
			  AND (p_state IS NULL OR state = p_state)
			  AND (p_country IS NULL OR country = p_country);
END