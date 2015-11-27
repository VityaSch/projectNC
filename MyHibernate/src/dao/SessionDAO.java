package dao;

import java.sql.SQLException;
import java.util.List;
import tables.Sesion;

public interface SessionDAO {
	public void addSession(Sesion session); 
	public void updateSession(Sesion session); 
	public Sesion getSessionById(int id) throws SQLException; 
	public List<Sesion> getAllSession() throws SQLException; 
	public void deleteSession(Sesion session); 
}
