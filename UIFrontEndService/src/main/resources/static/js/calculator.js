function submitFactorialForm(event) {
  event.preventDefault();

  const number = parseInt($('#number').val(), 10);

  // Validation: Only non-negative numbers allowed
  if (isNaN(number) || number < 0) {
    alert("Please enter a non-negative number.");
    return;
  }

  // Show loading spinner
  $('#resultContainer').html(`
    <div class="text-center mt-3">
      <div class="spinner-border text-primary" role="status">
        <span class="visually-hidden">Calculating...</span>
      </div>
      <p class="mt-2 text-muted">Calculating factorial...</p>
    </div>
  `);

  // http://localhost:6002/feign/factorial/
  //API GATEWAY: http://localhost:8765/feign-service/feign/factorial/
  $.ajax({
    url: `http://localhost:8765/feign-service/feign/factorial/${number}`,
    method: 'GET',
    success: function (response) {
      displayResult(response);
    },
    error: function () {
      $('#resultContainer').html(`
        <div class="alert alert-danger text-center">
          ❌ Failed to calculate factorial. Please try again later.
        </div>
      `);
    }
  });
}

function displayResult(data) {
  $('#resultContainer').html(`
    <div class="card shadow-sm border-success">
      <div class="card-body text-center">
        <h5 class="text-success mb-3">✅ Calculation Successful</h5>
        <p class="fs-5"><strong>Factorial:</strong> ${data}</p>
      </div>
    </div>
  `);
}
