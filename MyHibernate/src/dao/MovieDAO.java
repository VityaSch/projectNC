package dao;

import java.sql.SQLException;

import logic.Movie;

public interface MovieDAO {
	public void addMovie(Movie movie); // добавить фильм
	public void updateMovie(Movie movie); // обновить фильм
	public Movie getMovieById(int id) throws SQLException; // получить фильм по id
	public java.util.List<Movie> getAllMovie() throws SQLException; //получить все фильмы
	public void deleteMovie(Movie movie); //удалить фильм
	
}
