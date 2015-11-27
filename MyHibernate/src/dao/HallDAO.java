package dao;

import java.sql.SQLException;
import java.util.List;

import antlr.debug.Event;
import tables.Hall;

public interface HallDAO {
	public void addHall(Hall hall); 
	public void updateHall(Event hall); 
	public Hall getHallById(int id) throws SQLException; 
	public List<Hall> getAllHall() throws SQLException; 
	public void deleteHall(Hall hall); 
}
