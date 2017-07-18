package com.codylee.proctorfree.domain;


// This is the class definition for the Star Wars Movies
// it is going to mirror the database structure and fields
public class SwMovie {
	
	// Class variables
	private int id;
	private String movieTitle;
	private int movieReleaseYear;
	private String movieRuntime;
	private String movieDirector;
	private String movieGrossEarnings;
	
	// Constructor (empty)
	public SwMovie() {
		
	}
	
	// Constructor typically used when creating a movie
	public SwMovie(	String movieTitle, int movieReleaseYear, String movieRuntime, 
					String movieDirector, String movieGrossEarnings) 
	{
		super();
		this.movieTitle 			= movieTitle;
		this.movieReleaseYear 	= movieReleaseYear;
		this.movieRuntime 		= movieRuntime;
		this.movieDirector 		= movieDirector;
		this.movieGrossEarnings 	= movieGrossEarnings;
	}

	
	// ***** Getters and Setters *****
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieReleaseYear() {
		return movieReleaseYear;
	}
	public void setMovieReleaseYear(int movieReleaseYear) {
		this.movieReleaseYear = movieReleaseYear;
	}

	public String getMovieRuntime() {
		return movieRuntime;
	}
	public void setMovieRuntime(String movieRuntime) {
		this.movieRuntime = movieRuntime;
	}

	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieGrossEarnings() {
		return movieGrossEarnings;
	}
	public void setMovieGrossEarnings(String movieGrossEarnings) {
		this.movieGrossEarnings = movieGrossEarnings;
	}

	@Override
	public String toString() {
		return "SwMovies [id=" + id + ", movieTitle=" + movieTitle + ", movieReleaseYear=" + movieReleaseYear
				+ ", movieRuntime=" + movieRuntime + ", movieDirector=" + movieDirector + ", movieGrossEarnings="
				+ movieGrossEarnings + "]";
	}

	
} // end of SwMovies Class
