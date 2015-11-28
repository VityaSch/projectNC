package main;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import dao.Factory;
import models.Genre;
import models.Movie;
import models.News;

public class Main {
	public static void main(String[] args) throws SQLException{	

		/*Genre g = new Genre();
		Genre g2 = new Genre();
		g.setName("GENRE1");
		g2.setName("GENRE1");
		add(g);
		add(g2);*/
		
		//showAll();
		Date d = new Date(1000);
		Movie m = new Movie();
		m.setName("Movies1");
		m.setDerector("Derect1");
		m.setDescription("Description1");
		m.setShortDescription("ShortDescription");
		m.setLenght(d);
		m.setYearRelease(d);
		m.setGenres(Factory.getInstance().getGenreDAO().getAllGenre());
		

		
		News n = new News();
		n.setMovie_id(m);
		n.setName("name1");
		n.setDescription("description1");
		n.setDate(d);
		
		List<News> newList = new ArrayList<News>();
		newList.add(n);
		m.setNews(newList);
		Factory.getInstance().getMovieDAO().addMovie(m);
		n.setMovie_id(Factory.getInstance().getMovieDAO().getMovieById(1));
		//showAll();
	}
	
	private static void add(Genre g){
		Factory.getInstance().getGenreDAO().addGenre(g);
	}
	private static void update(Movie g){

		Factory.getInstance().getMovieDAO().updateMovie(g);;
	}
	private static void delete(int id) throws SQLException{
		Factory.getInstance().getGenreDAO().deleteGenre(Factory.getInstance().getGenreDAO().getGenreById(id));
	}
	private static void showAll() throws SQLException{
		List<Genre> genres = Factory.getInstance().getGenreDAO().getAllGenre();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < genres.size(); ++i) {
                System.out.println("name : " + genres.get(i).getName() +",  id : " + genres.get(i).getGenreId());
                System.out.println("=============================");              
        } 
	}
	private static void show(int id) throws SQLException{
		Genre g = Factory.getInstance().getGenreDAO().getGenreById(id);
		System.out.println("========Все студенты=========");
		System.out.println("name : " + g.getName() +",  id : " + g.getGenreId());
        System.out.println("=============================");        
	}
}
