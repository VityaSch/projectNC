package dao;

import java.sql.SQLException;
import java.util.List;
import models.Events;

public interface EventDAO {
	public void addMovie(Events event); 
	public void updateMovie(Events event); 
	public Events getMovieById(int id) throws SQLException; 
	public List<Events> getAllMovie() throws SQLException; 
	public void deleteMovie(Events event); 
}
