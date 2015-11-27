package dao;

import java.sql.SQLException;
import java.util.List;

import antlr.debug.Event;

public interface EventDAO {
	public void addMovie(Event event); 
	public void updateMovie(Event event); 
	public Event getMovieById(int id) throws SQLException; 
	public List<Event> getAllMovie() throws SQLException; 
	public void deleteMovie(Event event); 
}
