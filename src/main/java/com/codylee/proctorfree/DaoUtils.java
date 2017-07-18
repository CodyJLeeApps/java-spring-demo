package com.codylee.proctorfree;

import java.util.ArrayList;
import java.util.List;
import com.codylee.proctorfree.dao.SwMovieDao;
import com.codylee.proctorfree.domain.SwMovie;

public class DaoUtils {
	
	// All of the possible operations being used for the MySQL database.
	public static final String createOperation	= "CREATE";
	public static final String readOperation 		= "READ";
	public static final String updateOperation 	= "UPDATE";
	public static final String deleteOperation 	= "DELETE";
	public static final String truncateOperation 	= "TRUNCATE";
	
	// print movie info for ALL movies
	public static void printMovies(List<SwMovie> movies, String operation) {
		System.out.println("\n********** printing movies after " + operation + " operation **********");
		for(SwMovie movie : movies) {
			System.out.print(movie + "\n");
		}
	}
	
	// print all movie info
	public static void printMovie(SwMovie movie, String operation) {
		System.out.println(	"\n**********Printing movie after invoking " + 
							operation + " **********\n" + movie);
	}
	
	// Check if the operation was successful and print
	public static void printSuccessFailure(String operation, boolean param) {
		if(param)
		{
			System.out.println("\nOperation " + operation + " successful");
		}
		else 
		{
			System.out.println("\nOperation " + operation + " failed");
		}
	}
	
	// This class is used to create the template data for the user to see in the web application
	public static void createSeedData(SwMovieDao dao) {
		//SwMovie example = new SwMovie("title", year, "runtime", "director", gross_earnings);
		SwMovie movie1 = new SwMovie("Star Wars Episode IV: A New Hope", 					1977, "02:01", "George Lucas", 	"$460,935,665");
		SwMovie movie2 = new SwMovie("Star Wars Episode V: The Empire Strikes Back", 		1980, "02:04", "George Lucas", 	"$290,158,751");
		SwMovie movie3 = new SwMovie("Star Wars Episode VI: Return of the Jedi", 			1983, "02:11", "George Lucas", 	"$309,125,409");
		SwMovie movie4 = new SwMovie("Star Wars Episode I: The Phantom Menace", 			1999, "02:16", "George Lucas", 	"$474,544,677");
		SwMovie movie5 = new SwMovie("Star Wars Episode II: The Attack of the Clones",		2002, "02:22", "George Lucas", 	"$310,675,583");
		SwMovie movie6 = new SwMovie("Star Wars Episode III: The Revenge of the Sith", 	2005, "02:20", "George Lucas", 	"$380,262,555");
		SwMovie movie7 = new SwMovie("Star Wars Episode VII: The Force Awakens", 			2015, "02:16", "J.J. Abrams", 	"$936,627,416");
		SwMovie movie8 = new SwMovie("A Star Wars Story: Rogue One", 						2016, "02:13", "Gareth Edwards", "$532,171,696");	
		
		// Creata a list of SwMovies to add to the database
		List<SwMovie> movies = new ArrayList<SwMovie>();
		movies.add(0, movie1); movies.add(1, movie2); 
		movies.add(2, movie3); movies.add(3, movie4);
		movies.add(4, movie5); movies.add(5, movie6); 
		movies.add(6, movie7); movies.add(7, movie8);
		
		// loop through the movies created to confirm all correctly created
		int createCount = 0;
		for(SwMovie movie : movies) {
			boolean isCreated = dao.create(movie);
			if(isCreated)
			{
				createCount += 1;
			}
		}
		
		System.out.println("Created " + createCount + " movies");	
	}
	
	// Print the count of all movies in database
	public static void printMovieCount(List<SwMovie> movies, String operation) {
		System.out.println(	"\n**********Currently we have " + movies.size() + 
							" movies after " + operation + " operation **********");
	}
	
}
