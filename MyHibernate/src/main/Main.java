package main;

import java.sql.Time;
import java.sql.Date;
import java.sql.SQLException;

import logic.Genre;
import logic.Movie;
import dao.Factory;

public class Main {
	public static void main(String[] args) throws SQLException{	

		Genre g = new Genre();
		g.setName("genre1");	
		g.setGenreId(1);
		
		Factory.getInstance().getGenreDAO().addGenre(g);
	}
}
