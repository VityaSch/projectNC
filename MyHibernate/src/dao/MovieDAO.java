package dao;

import java.sql.SQLException;
import java.util.List;

import models.Movie;

public interface MovieDAO {
	public void addMovie(Movie movie); // добавить 
	public void updateMovie(Movie movie); // обновить 
	public Movie getMovieById(int id) throws SQLException; // получить  по id
	public List<Movie> getAllMovie() throws SQLException; //получить все 
	public void deleteMovie(Movie movie); //удалить 
	
}
