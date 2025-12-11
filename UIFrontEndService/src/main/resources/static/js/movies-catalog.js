let allMovies = [];

$(document).ready(() => {
	getMovies();
});

function getMovies() {
	//http://localhost:7003/catalogs/
	//API Gateway: http://localhost:8765/catalogs-info-service/catalogs/
  $.ajax({
    url: 'http://localhost:8765/catalogs-info-service/catalogs/',
    method: 'GET',
    success: function (response) {
      allMovies = response.movieRatings;
      renderMovieTable(allMovies);
    },
    error: () => {
      $('#moviesTableContainer').html('<div class="alert alert-danger">Failed to load data.</div>');
    }
  });
}

function renderMovieTable(movies) {
  let html = `<table class="table table-striped table-bordered">
    <thead class="table-dark">
      <tr>
	      <th>User ID</th>
	      <th>Movie ID</th>
	      <th>Movie Name</th>
	      <th>Description</th>
	      <th>Rating</th>
      </tr>
    </thead>
    <tbody>`;

  movies.forEach(s => {
    html += `<tr>
      <td>${s.userId}</td>
      <td>${s.movieId}</td>
      <td>${s.movieName}</td>
      <td>${s.description}</td>
      <td>${s.rating}</td>
    </tr>`;
  });

  html += '</tbody></table>';
  $('#moviesTableContainer').html(html);
}

function filterMovies() {
	  const userId = $('#searchUserId').val().toLowerCase();
	  const movieId = $('#searchMovieId').val().toLowerCase();
	  const movieName = $('#searchMovieName').val().toLowerCase();
	  const description = $('#searchDescription').val().toLowerCase();
	  const rating = $('#searchRating').val().toLowerCase();

	  const filtered = allMovies.filter(movie => {
	    return (
	      (!userId || movie.userId.toLowerCase().includes(userId)) &&
	      (!movieId || movie.movieId.toLowerCase().includes(movieId)) &&
	      (!movieName || movie.movieName.toLowerCase().includes(movieName)) &&
	      (!description || movie.description.toLowerCase().includes(description)) &&
	      (!rating || movie.rating.toString().includes(rating))
	    );
	  });
	  renderMovieTable(filtered);
}