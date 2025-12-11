function submitWeightForm(event) {
  event.preventDefault();

  const name = $('#name').val().trim();
  const currentWeight = parseFloat($('#currentWeight').val());
  const desiredWeight = parseFloat($('#desiredWeight').val());
  const caloriesLossPerDay = parseInt($('#caloriesLossPerDay').val());

  // Client-side validations
  if (!name || isNaN(currentWeight) || isNaN(desiredWeight) || isNaN(caloriesLossPerDay)) {
    alert("⚠️ Please fill all fields correctly.");
    return;
  }

  if (currentWeight <= 0 || desiredWeight <= 0) {
    alert("⚖️ Weight must be a positive number.");
    return;
  }

  if (currentWeight <= desiredWeight) {
    alert("⚠️ Current weight must be greater than desired weight.");
    return;
  }

  if (caloriesLossPerDay <= 0) {
    alert("⚠️ Calories loss per day must be a positive number.");
    return;
  }

  const data = {
    name,
    currentWeightInKg: currentWeight,
    desiredWeightInKg: desiredWeight,
    caloriesLossPerDay
  };

  $('#resultContainer').html('<div class="text-center mt-3"><div class="spinner-border text-primary" role="status"><span class="visually-hidden">Loading...</span></div></div>');
//http://localhost:8001/weight-management/details

//API Gateway Based URL: 
//http://localhost:8765/weight-management-service/weight-management/details	 
  $.ajax({
    url: 'http://localhost:8765/weight-management-service/weight-management/details',
    method: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(data),
    success: function (response) {
      displayResult(response);
    },
    error: function () {
      $('#resultContainer').html('<div class="alert alert-danger">❌ Failed to calculate plan. Try again later.</div>');
    }
  });
}


function displayResult(data) {
  const html = `
    <div class="card shadow-sm">
      <div class="card-header bg-success text-white">
        <h5 class="mb-0">🎯 Weight Loss Plan for ${data.name}</h5>
      </div>
      <div class="card-body">
        <p><strong>📅 Today:</strong> ${data.today}</p>
        <p><strong>⚖️ Current Weight:</strong> ${data.currentWeightInKg} kg</p>
        <p><strong>🎯 Goal Weight:</strong> ${data.desiredWeightInKg} kg</p>
        <p><strong>➖ Weight to Lose:</strong> ${data.requiredWeightLossInKg.toFixed(2)} kg</p>
        <hr />
        <p><strong>🔥 Calories Burnt Per Day:</strong> ${data.caloriesLossPerDay} kcal</p>
        <p><strong>📆 Days to Lose 1 kg:</strong> ${data.daysToLossOnekgWeight.toFixed(1)} days</p>
        <p><strong>📅 Total Days Required:</strong> ${data.daysToLossRequiredWeight.toFixed(0)} days</p>
        <p><strong>🗓️ Months Required:</strong> ${data.monthsToLossRequiredWeight.toFixed(1)} months</p>
        <p><strong>🗓️ Years Required:</strong> ${data.yearsToLossRequiredWeight.toFixed(2)} years</p>
        <hr />
        <p><strong>🏁 Target Achievement Day:</strong> <span class="text-success fw-bold">${data.achievementDay}</span></p>
      </div>
    </div>
  `;

  $('#resultContainer').html(html);
}
