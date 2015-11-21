package dao;

import java.sql.SQLException;
import logic.Genre;

public interface GenreDAO {
	public void addGenre(Genre genre) throws SQLException;   
}
