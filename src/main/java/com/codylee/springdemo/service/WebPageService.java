package com.codylee.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.codylee.proctorfree.DaoUtils;
import com.codylee.proctorfree.dao.SwMovieDao;
import com.codylee.proctorfree.domain.SwMovie;

// This service performs the function of a "main" function
// The basic operations are: create data, place in database,
// read from database, output to webpage.
@Service
public class WebPageService implements GenericWebPageService {

	public List<String> getSwData() {

		List<String> swData = new ArrayList<>();
		// Add data to the list
		//swData.add("Hello! ");

		// Create the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		SwMovieDao dao = (SwMovieDao) ctx.getBean("swDao");

		// Creating the "seed" test data so we can output the data to the screen
		DaoUtils.createSeedData(dao);

		// List movies currently in database
		List<SwMovie> movies = dao.getAllMovies();
		// Loop through movie list and add to data to output to screen
		for (SwMovie movie : movies) {
			swData.add( "ID: " + movie.getId() +
						", Title: " + movie.getMovieTitle() +
						", Year: " + movie.getMovieReleaseYear() +
						", Runtime: " + movie.getMovieRuntime() +
						", Director: " + movie.getMovieDirector() +
						", Gross Earnings: " + movie.getMovieGrossEarnings() );
		}
		DaoUtils.printMovies(movies, DaoUtils.readOperation);

		// delete all of the data from the database, 
		// it will be re-created at startup.
		dao.cleanup();

		// Close the application context
		((ClassPathXmlApplicationContext) ctx).close();

		return swData; // return the data to be displayed in the view
	}

} // End WelcomeService Class
