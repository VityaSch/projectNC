package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Tickets;

public interface TicketsDAO {
	public void addTickets(Tickets tickets); 
	public void updateTickets(Tickets tickets); 
	public Tickets getTicketsById(int id) throws SQLException; 
	public List<Tickets> getAllMovie() throws SQLException; 
	public void deleteTickets(Tickets tickets); 
}
