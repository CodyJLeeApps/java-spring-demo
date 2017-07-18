package com.codylee.proctorfree.daoimpl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.codylee.proctorfree.dao.SwMovieDao;
import com.codylee.proctorfree.domain.SwMovie;

// This is the implimentation of the interface previously created.
// This implimentation allows the application to make the database queries.
@Repository("swDao")
public class SwMovieDaoImpl implements SwMovieDao {

	// JDBC Template is used to query the MySQL database
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	// based on the movie passed into the method, create a new movie in the database
	public boolean create(SwMovie movie) {
		
		String sqlQuery = 	"INSERT INTO sw_movies (title, release_year, runtime, director, gross_earnings) " +
							"VALUES(?,?,?,?,?)";
		
		Object[] args = new Object[] { 	movie.getMovieTitle(), movie.getMovieReleaseYear(), movie.getMovieRuntime(), 
										movie.getMovieDirector(), movie.getMovieGrossEarnings() };
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	// retrieve a movie from the database based on the id passed into the method
	public SwMovie getOrganization(Integer id) {
		String sqlQuery = 	"SELECT id, title, release_year, runtime, director, gross_earnings " +
							"FROM sw_movies WHERE id = ?";
		
		Object[] args = new Object[] {id};
		SwMovie movie = jdbcTemplate.queryForObject(sqlQuery, args, new SwMovieRowMapper());
		return movie;
	}

	// get all movies from the database
	public List<SwMovie> getAllMovies() {
		String sqlQuery = "SELECT * FROM sw_movies";
		List<SwMovie> orgList = jdbcTemplate.query(sqlQuery, new SwMovieRowMapper());
		return orgList;
	}

	// Delete a movie from the database by pulling the id from the movie passed in
	public boolean delete(SwMovie movie) {
		String sqlQuery =  "DELETE FROM sw_movies WHERE id = ?";
		Object[] args = new Object[] {movie.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	// Deletes ALL movies from the database table
	public void cleanup() {
		String sqlQuery =  "TRUNCATE TABLE sw_movies ";
		jdbcTemplate.execute(sqlQuery);	
	}

}
