package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Genre;



public interface GenreDAO {
	public void addGenre(Genre genre); // добавить 
	public void updateGenre(Genre genre); // обновить 
	public Genre getGenreById(int id) throws SQLException; // получить  по id
	public List<Genre> getAllGenre() throws SQLException; //получить все 
	public void deleteGenre(Genre genre); //удалить 
}
