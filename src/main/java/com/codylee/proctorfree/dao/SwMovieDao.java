package com.codylee.proctorfree.dao;

import java.util.List;
import javax.sql.DataSource;
import com.codylee.proctorfree.domain.SwMovie;

// This is the definition of the SwMovieDao, 
// it is the overall structural design of the DAO
public interface SwMovieDao {
	
	// Set the data-source that will be required to create
	public void setDataSource(DataSource ds);
	
	// Create a record in the organization table
	public boolean create(SwMovie org);
	
	// Retrieve a single organization by id
	public SwMovie getOrganization(Integer id);
	
	// Retrieve all organizations from table.
	public List<SwMovie> getAllMovies();
	
	// Delete a specific organization from table by id.
	public boolean delete(SwMovie org);
	
	public void cleanup();
	
}
