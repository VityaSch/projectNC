package main;

import java.sql.Time;
import java.sql.Date;
import java.sql.SQLException;

import logic.Genre;
import logic.Movie;
import dao.Factory;

public class Main {
	public static void main(String[] args) throws SQLException{	
		
		
		//String dates = "2000-11-01";
		//Date date = Date.valueOf(dates);
		//Time time = new Time(12,24,13);

		//Movie m = new Movie();
		//m.setName("Ёвирест");
		//m.setDerector("123");
		//m.setShortDescription("123");
		//m.setDescription("123");
		//m.setYearRelease(null);
		//m.setLenght(null);
		
		Genre g = new Genre();
		
		g.setName("genre1");	
		g.setGenreId(1);
		//Factory.getInstance().getMovieDAO().addMovie(m);
		
		Factory.getInstance().getGenreDAO().addGenre(g);
	}
}
