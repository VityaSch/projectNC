package dao;

import java.sql.SQLException;
import java.util.List;
import models.Events;

public interface EventDAO {
	public void addEvent(Events event);
	public void updateEvent(Events event);
	public Events getEventById(int id) throws SQLException;
	public List<Events> getAllEvent() throws SQLException;
	public void deleteEvent(Events event);
}
