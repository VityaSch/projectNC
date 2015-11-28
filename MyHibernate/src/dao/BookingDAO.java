package dao;

import java.sql.SQLException;
import java.util.List;

import antlr.debug.Event;
import models.Booking;

public interface BookingDAO {
	public void addBooking(Booking booking); 
	public void updateBooking(Booking booking); 
	public Booking getBookingById(int id) throws SQLException; 
	public List<Booking> getAllBooking() throws SQLException; 
	public void deleteBooking(Booking booking); 
}
