package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Genre;



public interface GenreDAO {
	public void addGenre(Genre genre); // �������� 
	public void updateGenre(Genre genre); // �������� 
	public Genre getGenreById(int id) throws SQLException; // ��������  �� id
	public List<Genre> getAllGenre() throws SQLException; //�������� ��� 
	public void deleteGenre(Genre genre); //������� 
}
