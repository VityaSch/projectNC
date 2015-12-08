package main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import control.AdminController;
import dao.Factory;
import models.*;
import oracle.sql.TIMESTAMP;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.StartView;
import view.UserView;

public class Main {
	public static void main(String[] args) throws SQLException{

		//Genre g2 = new Genre();
		//g2.setName("GE22222wq");
		///add(g2);
		//showAll();
		/*Date d = new Date(1000);
		Movie m = new Movie();
		m.setName("Movies1");
		m.setDirector("Derect1");
		m.setDescription("Description1");
		m.setShortDescription("ShortDescription");
		m.setLenght(d);
		m.setYearRelease(d);
		m.setGenres(Factory.getInstance().getGenreDAO().getAllGenre());
		Factory.getInstance().getMovieDAO().addMovie(m);*/
		/*Date date = new Date((2015-1900),1,5,12,30,00);

		Sesion session = new Sesion();
		session.setMovieId(Factory.getInstance().getMovieDAO().getMovieById(1));
		session.setHallId(Factory.getInstance().getHallDAO().getHallById(1));
		session.setDate(date);
		Factory.getInstance().getSessionDAO().addSession(session);*/

		//n.setMovie_id(Factory.getInstance().getMovieDAO().getMovieById(1));
		//showAll();
		//SimpleDateFormat ft = new SimpleDateFormat ("dd.mm.yyyy");
		//System.out.println(ft.format(Factory.getInstance().getSessionDAO().getSessionById(5).getDate()));

		/*Date dNow = Factory.getInstance().getSessionDAO().getSessionById(5).getDate();
		SimpleDateFormat ft =
				new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
		*/
		/*SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
		Date d = Factory.getInstance().getSessionDAO().getSessionById(1).getDate();
		System.out.println("2015.02.05".equals(ft.format(d)));
*/
		/*Sesion s = new Sesion();
		s.setDate(new java.sql.Date(1));
		s.setHallId(Factory.getInstance().getHallDAO().getHallById(1));
		s.setMovieId(Factory.getInstance().getMovieDAO().getMovieById(2));
		Factory.getInstance().getSessionDAO().addSession(s);*/


		//Tickets t = new Tickets(new Sesion(),new Place(),new java.sql.Date(1),100);
		//Factory.getInstance().getTicketsDAO().addTickets(t);

	/*	Sesion session = new Sesion();
		session.setMovieId(Factory.getInstance().getMovieDAO().getMovieById(1));
		session.setHallId(Factory.getInstance().getHallDAO().getHallById(1));
		session.setDate(new Date());

		Factory.getInstance().getSessionDAO().addSession(session);
		System.out.println(session.getSessionId());
*/
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		StartView start = (StartView) context.getBean("startView");
		start.showStartMenu();

		//new StartView().showStartMenu();
		//new AdminController().updateMovie(Factory.getInstance().getMovieDAO().getMovieById(1));
		//Factory.getInstance().getMovieDAO().addMovie(createMovie("test","test","test",new DATE(),new DATE(),"test"));
	}

	/*private static Movie createMovie(String name, String director, String description, DATE time, DATE date, String shortDescription){
		Movie movie = new Movie();
		movie.setName(name);
		movie.setDirector(director);
		movie.setDescription(description);
		movie.setShortDescription(shortDescription);
		movie.setLenght(time);s
		movie.setYearRelease(date);

		return movie;
	}*/


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
		List<Tickets> genres = Factory.getInstance().getTicketsDAO().getAllTickets();

        for(int i = 0; i < genres.size(); i++) {
                System.out.println("name : " + genres.get(i).getPrice() +",  id : " + genres.get(i).getTicketId());
                System.out.println("=============================");
        }
	}
	private static void show(int id) throws SQLException{
		Sesion g = Factory.getInstance().getSessionDAO().getSessionById(id);
		System.out.println("========��� ��������=========");
		System.out.println("name : " + g.getMovieId().getName() +",  id : " + g.getSessionId());
        System.out.println("=============================");
	}
}
