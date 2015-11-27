package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Sale;

public interface SaleDAO {
	public void addSale(Sale sale); 
	public void updateSale(Sale sale); 
	public Sale getSaleById(int id) throws SQLException; 
	public List<Sale> getAllSale() throws SQLException; 
	public void deleteSale(Sale sale); 
}
