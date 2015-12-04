package dao;

import java.sql.SQLException;
import java.util.List;

import models.News;

public interface NewsDAO {
	public void addNews(News news); 
	public void updateNews(News news); 
	public News getNewsById(int id) throws SQLException; 
	public List<News> getAllNews() throws SQLException; 
	public void deleteNews(News news); 
}
