package dao;

import java.sql.SQLException;
import java.util.List;

import models.Movie;

public interface MovieDAO {
	public void addMovie(Movie movie); // �������� 
	public void updateMovie(Movie movie); // �������� 
	public Movie getMovieById(int id) throws SQLException; // ��������  �� id
	public List<Movie> getAllMovie() throws SQLException; //�������� ��� 
	public void deleteMovie(Movie movie); //������� 
	
}
