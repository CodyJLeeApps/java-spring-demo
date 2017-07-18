package com.codylee.proctorfree.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.codylee.proctorfree.domain.SwMovie;

// The RowMapper takes the data provided by the MySQL database
// and maps it to the correct variables as set up in the "SwMovie.java" class
public class SwMovieRowMapper implements RowMapper<SwMovie> {

	public SwMovie mapRow(ResultSet rs, int rownum) throws SQLException {
		// Create a new organization object to pull data
		SwMovie movie = new SwMovie();
		
		// pull data from database results
		movie.setId(rs.getInt("id"));
		movie.setMovieTitle(rs.getString("title"));
		movie.setMovieReleaseYear(rs.getInt("release_year"));
		movie.setMovieRuntime(rs.getString("runtime"));
		movie.setMovieDirector(rs.getString("director"));
		movie.setMovieGrossEarnings(rs.getString("gross_earnings"));
		
		return movie;
	}
	
}
