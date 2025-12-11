let allStudents = [];
let modalInstance;

$(document).ready(() => {
  modalInstance = new bootstrap.Modal(document.getElementById('studentModal'));
  getStudents();
});

function getStudents() {
	//http://localhost:8002/students/
	//API GATEWAY: http://localhost:8765/students-management-service/students/
  $.ajax({
    url: 'http://localhost:8765/students-management-service/students/',
    method: 'GET',
    success: function (response) {
      allStudents = response.students;
      renderStudentTable(allStudents);
    },
    error: () => {
      $('#studentTableContainer').html('<div class="alert alert-danger">Failed to load data.</div>');
    }
  });
}

function renderStudentTable(students) {
  let html = `<table class="table table-striped table-bordered">
    <thead class="table-dark">
      <tr><th>ID</th><th>Name</th><th>Actions</th></tr>
    </thead><tbody>`;

  students.forEach(s => {
    html += `<tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>
        <button class="btn btn-sm btn-warning me-2" onclick="editStudent(${s.id})">Edit</button>
        <button class="btn btn-sm btn-danger" onclick="deleteStudent(${s.id})">Delete</button>
      </td>
    </tr>`;
  });

  html += '</tbody></table>';
  $('#studentTableContainer').html(html);
}

function filterStudents() {
  const search = $('#searchInput').val().toLowerCase();
  const filtered = allStudents.filter(s => s.name.toLowerCase().includes(search));
  renderStudentTable(filtered);
}

function showAddModal() {
  $('#studentId').val('');
  $('#studentName').val('');
  $('.modal-title').text('Add Student');
  modalInstance.show();
}

function editStudent(id) {
  const student = allStudents.find(s => s.id === id);
  if (!student) 
	  return;

  $('#studentId').val(student.id);
  $('#studentName').val(student.name);
  $('.modal-title').text('Edit Student');
  modalInstance.show();
}

function saveStudent(event) {
  event.preventDefault();

  const id = $('#studentId').val();
  const name = $('#studentName').val().trim();
  let studentData = '';

  if (id) {
	  studentData = JSON.stringify({ id: parseInt(id), name });
    // Update
    $.ajax({
      url: `http://localhost:8765/students-management-service/students/`,
      method: 'PUT',
      contentType: 'application/json',
      data: studentData,
      success: () => {
        modalInstance.hide();
        getStudents();
      }
    });
  } else {
    // Create
	  studentData = JSON.stringify({ name });
    $.ajax({
      url: 'http://localhost:8765/students-management-service/students/',
      method: 'POST',
      contentType: 'application/json',
      data: studentData,
      success: () => {
        modalInstance.hide();
        getStudents();
      }
    });
  }
}

function deleteStudent(id) {
  if (!confirm('Are you sure you want to delete this student?')) 
	  return;

  $.ajax({
    url: `http://localhost:8765/students-management-service/students/id/${id}`,
    method: 'DELETE',
    success: () => getStudents()
  });
}