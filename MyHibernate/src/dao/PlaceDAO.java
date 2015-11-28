package dao;

import java.sql.SQLException;
import java.util.List;

import models.Place;

public interface PlaceDAO {
	public void addPlace(Place place); 
	public void updatePlace(Place place); 
	public Place getPlaceById(int id) throws SQLException; 
	public List<Place> getAllPlace() throws SQLException; 
	public void deletePlace(Place place); 
}
