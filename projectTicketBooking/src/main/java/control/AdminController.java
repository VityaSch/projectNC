package control;

import dao.Factory;
import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.AdminViewImpl;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private EnterController enter;

    public AdminController(){
    }

    public EnterController getEnter() {
        return enter;
    }

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }

    public void addMovie(Movie movies, String name, String director, String description, Date time, Date date, String shortDescription, boolean add) throws SQLException {
        Movie movie = movies;
        movie.setName(name);
        movie.setDirector(director);
        movie.setDescription(description);
        movie.setShortDescription(shortDescription);
        movie.setLenght(time);
        movie.setYearRelease(date);
        movie.setGenres(allGenre());
        if(add) Factory.getInstance().getMovieDAO().addMovie(movie);
        else Factory.getInstance().getMovieDAO().updateMovie(movie);
    }
    private List<Genre> allGenre() throws SQLException {
        List<Genre> rezultGenres = new ArrayList<Genre>();
        enter.showAllGenres();
        while(true){
            int e = enter.getInt();
            if(e <= 0) break;
            if(e <= Factory.getInstance().getGenreDAO().getAllGenre().size()) rezultGenres.add(Factory.getInstance().getGenreDAO().getGenreById(e));
        }
        return rezultGenres;
    }

    public void addGenre(Genre g,boolean add,String name){
        if(add) {
            Factory.getInstance().getGenreDAO().addGenre(new Genre(name));
        }
        else {
            Genre genre = g;
            genre.setName(name);
            Factory.getInstance().getGenreDAO().updateGenre(genre);
        }
    }

    public void addNews(News newse, boolean add, Movie movie, String name, String description, Date date){
        News news = newse;
        news.setName(name);
        news.setMovie_id(movie);
        news.setDescription(description);
        news.setDate(date);
        if(add) Factory.getInstance().getNewsDAO().addNews(news);
        else Factory.getInstance().getNewsDAO().updateNews(news);
    }

    public void addEvent(Events ev, boolean add, String name, Date dateNew, Date dateEnd, String desc, int discount) throws SQLException {
        Events event = ev;
        event.setName(name);
        event.setDateNew(dateNew);
        event.setDateEnd(dateEnd);
        event.setDescription(desc);
        event.setMovies(allMovie());
        event.setDiscount(discount);
        if(add) Factory.getInstance().getEventDAO().addEvent(event);
        else Factory.getInstance().getEventDAO().updateEvent(event);
    }
    private List<Movie> allMovie() throws SQLException {
        System.out.println("Выбери фильмы");
        List<Movie> rezultMovies = new ArrayList<Movie>();

        while(true){
            enter.showAllMovie();
            int e = enter.getInt();
            if(e <= 0) break;
            if(e <= Factory.getInstance().getMovieDAO().getAllMovie().size()) rezultMovies.add(Factory.getInstance().getMovieDAO().getMovieById(e));
        }
        return rezultMovies;
    }

    public void addSession(Sesion s, boolean add, Movie movieId, Hall hallId, Date date, int price) throws SQLException {
        Sesion session = s;
        session.setMovieId(movieId);
        session.setHallId(hallId);
        session.setDate(date);
        Factory.getInstance().getSessionDAO().addSession(session);
        session.setTicket(createTicketsInSession(session,price));
        if(add) Factory.getInstance().getSessionDAO().updateSession(session);
        else Factory.getInstance().getSessionDAO().updateSession(session);
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

    public <T> void delete(T o){
        if(o.getClass().equals(Movie.class)) Factory.getInstance().getMovieDAO().deleteMovie((Movie) o);
        if(o.getClass().equals(Genre.class)) Factory.getInstance().getGenreDAO().deleteGenre((Genre) o);
        if(o.getClass().equals(News.class)) Factory.getInstance().getNewsDAO().deleteNews((News) o);
        if(o.getClass().equals(Events.class)) Factory.getInstance().getEventDAO().deleteEvent((Events) o);
        if(o.getClass().equals(Sesion.class)) Factory.getInstance().getSessionDAO().deleteSession((Sesion) o);
    }

}
