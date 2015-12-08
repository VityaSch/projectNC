package control;

import dao.Factory;
import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.AdminView;
import view.ExceptionView;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private Scanner scn = new Scanner(System.in);
    ApplicationContext contextAdminView = new ClassPathXmlApplicationContext("spring-config.xml");
    AdminView adminView = null;
    EnterController enter = null;

    public void  selectAdd(Class cl) throws SQLException {
        adminView = (AdminView) contextAdminView.getBean("adminView");
        if(cl.equals(Movie.class)){
            adminView.showMenuUpdateAddMovie();
        }
        if(cl.equals(Genre.class)){
            adminView.showMunuAddGenre();
        }
        if(cl.equals(News.class)){
            adminView.showMenuAddNews();
        }
        if(cl.equals(Events.class)){
            adminView.showMenuAddEvent();
        }
        if(cl.equals(Sesion.class)){
            adminView.showMenuAddSession();
        }
    }

    public void addMovie(String name, String director, String description, Date time, Date date, String shortDescription) throws SQLException {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDirector(director);
        movie.setDescription(description);
        movie.setShortDescription(shortDescription);
        movie.setLenght(time);
        movie.setYearRelease(date);
        movie.setGenres(allGenre());

        Factory.getInstance().getMovieDAO().addMovie(movie);
    }
    private List<Genre> allGenre() throws SQLException {
        adminView = (AdminView) contextAdminView.getBean("adminView");
        enter = (EnterController) contextAdminView.getBean("enter");
        List<Genre> rezultGenres = new ArrayList<Genre>();
        adminView.showAllGenres();
        while(true){
            int e = enter.getInt();
            if(e <= 0) break;
            if(e <= Factory.getInstance().getGenreDAO().getAllGenre().size()) rezultGenres.add(Factory.getInstance().getGenreDAO().getGenreById(e));
        }
        return rezultGenres;
    }

    public void addGenre(String name){
        Factory.getInstance().getGenreDAO().addGenre(new Genre(name));
    }

    public void addNews(Movie movie, String name, String description, Date date){
        News news = new News();
        news.setName(name);
        news.setMovie_id(movie);
        news.setDescription(description);
        news.setDate(date);
        Factory.getInstance().getNewsDAO().addNews(news);
    }

    public void addEvent(String name, Date dateNew, Date dateEnd, String desc, int discount) throws SQLException {
        Events event = new Events();
        event.setName(name);
        event.setDateNew(dateNew);
        event.setDateEnd(dateEnd);
        event.setDescription(desc);
        event.setMovies(allMovie());
        event.setDiscount(discount);
        Factory.getInstance().getEventDAO().addEvent(event);
    }
    private List<Movie> allMovie() throws SQLException {
        adminView = (AdminView) contextAdminView.getBean("adminView");
        enter = (EnterController) contextAdminView.getBean("enter");
        System.out.println("Выбери фильмы");
        List<Movie> rezultMovies = new ArrayList<Movie>();

        while(true){
            adminView.showAllMovie();
            int e = enter.getInt();
            if(e <= 0) break;
            if(e <= Factory.getInstance().getMovieDAO().getAllMovie().size()) rezultMovies.add(Factory.getInstance().getMovieDAO().getMovieById(e));
        }
        return rezultMovies;
    }

    public void addSession(Movie movieId, Hall hallId, Date date, int price) throws SQLException {
        Sesion session = new Sesion();
        session.setMovieId(movieId);
        session.setHallId(hallId);
        session.setDate(date);
        Factory.getInstance().getSessionDAO().addSession(session);
        session.setTicket(createTicketsInSession(session,price));
        Factory.getInstance().getSessionDAO().updateSession(session);
    }
    private List<Tickets> createTicketsInSession(Sesion thisSession, int price) throws SQLException {
        List<Place> placeInHalls = Factory.getInstance().getPlaceDAO().getAllPlace();
        List<Tickets> rezultTickets = new ArrayList<Tickets>();

       for(int i=0; i<placeInHalls.size();i++){
           if(thisSession.getHallId().equals(placeInHalls.get(i).getHall())){
               Tickets tickets = new Tickets();
               tickets.setPlaceId(placeInHalls.get(i));
               tickets.setPrice(price);
               tickets.setDate(thisSession.getDate());
               tickets.setSessionId(thisSession);
               rezultTickets.add(tickets);
           }
       }

        return  rezultTickets;
    }



   /* public void updateMovie(Movie movie) throws SQLException {
        System.out.println("Введите название фильма ");
        movie.setName(scn.next());
        System.out.println("Введите режисера");
        movie.setDirector(scn.next());
        System.out.println("Введите описание");
        movie.setDescription(scn.next());
        System.out.println("Введите краткое описание");
        movie.setShortDescription(scn.next());
        System.out.println("Введите год релиза");
        int yyyy = scn.nextInt();
        System.out.println("Введите месяц релиза");
        int mm = scn.nextInt();
        System.out.println("Введите день релиза");
        int dd = scn.nextInt();
        System.out.println("Введите продолжительность фильма");
        System.out.println("Введите час");
        int hh = scn.nextInt();
        System.out.println("Введите минуты");
        int mi = scn.nextInt();
        java.util.Date dNow = new java.util.Date(yyyy,mm,dd,hh,mi,00);
        movie.setYearRelease(dNow);
        movie.setLenght(dNow);
        movie.setGenres(allGenre());

        Factory.getInstance().getMovieDAO().updateMovie(movie);
    }

    public void updateGenre(Genre genre) throws SQLException {
        System.out.println("Введите название жанра ");
        genre.setName(scn.next());
        Factory.getInstance().getGenreDAO().updateGenre(genre);
    }*/



}
