let allEmployee = [];
let modalInstance;

$(document).ready(() => {
  modalInstance = new bootstrap.Modal(document.getElementById('employeeModal'));
  getEmployees();
});

function getEmployees() {
	//http://localhost:8003/employees/v1
	//API Gateway: http://localhost:8765/employees-management-service/employees/v1
  $.ajax({
    url: 'http://localhost:8765/employees-management-service/employees/v1',
    method: 'GET',
    success: function (response) {
      allEmployee = response.employees;
      renderEmployeeTable(allEmployee);
    },
    error: () => {
      $('#employeeTableContainer').html('<div class="alert alert-danger">Failed to load data.</div>');
    }
  });
}

function renderEmployeeTable(employees) {
  let html = `<table class="table table-striped table-bordered">
    <thead class="table-dark">
      <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Salary</th>
      <th>City</th>
      <th>State</th>
      <th>Country</th>
      <th>Actions</th>
      </tr>
    </thead>
    <tbody>`;

  employees.forEach(s => {
    html += `<tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.salary}</td>
      <td>${s.city}</td>
      <td>${s.state}</td>
      <td>${s.country}</td>
      <td>
        <button class="btn btn-sm btn-warning me-2" onclick="editEmployee(${s.id})">Edit</button>
        <button class="btn btn-sm btn-danger" onclick="deleteEmployee(${s.id})">Delete</button>
      </td>
    </tr>`;
  });

  html += '</tbody></table>';
  $('#employeeTableContainer').html(html);
}

function filterEmployees() {
	  const name = $('#searchName').val().toLowerCase();
	  const salary = $('#searchSalary').val();
	  const city = $('#searchCity').val().toLowerCase();
	  const state = $('#searchState').val().toLowerCase();
	  const country = $('#searchCountry').val().toLowerCase();

	  const filtered = allEmployee.filter(emp => {
	    return (
	      (!name || emp.name.toLowerCase().includes(name)) &&
	      (!salary || emp.salary.toString().includes(salary)) &&
	      (!city || emp.city.toLowerCase().includes(city)) &&
	      (!state || emp.state.toLowerCase().includes(state)) &&
	      (!country || emp.country.toLowerCase().includes(country))
	    );
	  });

	  renderEmployeeTable(filtered);
}


function showAddModal() {
  $('#employeeId').val('');
  $('#employeeName').val('');
  $('#employeeSalary').val('');
  $('#employeeCity').val('');
  $('#employeeState').val('');
  $('#employeeCountry').val('');
  $('.modal-title').text('Add Employee');
  modalInstance.show();
}

function editEmployee(id) {
  const employee = allEmployee.find(s => s.id === id);
  if (!employee) 
	  return;

  $('#employeeId').val(employee.id);
  $('#employeeName').val(employee.name);
  $('#employeeSalary').val(employee.salary);
  $('#employeeCity').val(employee.city);
  $('#employeeState').val(employee.state);
  $('#employeeCountry').val(employee.country);
  $('.modal-title').text('Edit Employee');
  modalInstance.show();
}

function saveEmployee(event) {
  event.preventDefault();

  const id = $('#employeeId').val();
  const name = $('#employeeName').val().trim();
  const salary = $('#employeeSalary').val();
  const city = $('#employeeCity').val().trim();
  const state = $('#employeeState').val().trim();
  const country = $('#employeeCountry').val().trim();
  let employeeData = '';

  if (id) {
	  employeeData = JSON.stringify({ id, name, salary, city, state, country });
    // Update
	//http://localhost:8003/employees/
	//API Gateway: http://localhost:8765/employees-management-service/employees/
    $.ajax({
      url: `http://localhost:8765/employees-management-service/employees/`,
      method: 'PUT',
      contentType: 'application/json',
      data: employeeData,
      success: () => {
        modalInstance.hide();
        getEmployees();
      }
    });
  } else {
    // Create
	  employeeData = JSON.stringify({ name, salary, city, state, country });
    $.ajax({
      url: 'http://localhost:8765/employees-management-service/employees/',
      method: 'POST',
      contentType: 'application/json',
      data: employeeData,
      success: () => {
        modalInstance.hide();
        getEmployees();
      }
    });
  }
}

function deleteEmployee(id) {
  if (!confirm('Are you sure you want to delete this employee?')) 
	  return;
//http://localhost:8003/employees/id/
//API Gateway: http://localhost:8765/employees-management-service/employees/id/
  $.ajax({
    url: `http://localhost:8765/employees-management-service/employees/id/${id}`,
    method: 'DELETE',
    success: () => getEmployees()
  });
}