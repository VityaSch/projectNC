package dao;

import impl.GenreDAOImpl;
import impl.MovieDAOImpl;

public class Factory {
	private static MovieDAO movieDAO = null;
	private static GenreDAO genreDAO = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance(){
          if (instance == null){
            instance = new Factory();
          }
          return instance;
    }
	
	public MovieDAO getMovieDAO(){
        if (movieDAO == null){
        	movieDAO = new MovieDAOImpl();
        }
        return movieDAO;
  }   
	
	public GenreDAO getGenreDAO(){
        if (genreDAO == null){
        	genreDAO = new GenreDAOImpl();
        }
        return genreDAO;
  }   
}
