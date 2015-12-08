package control;

import dao.Factory;
import models.*;
import view.AdminView;
import view.ExceptionView;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private Scanner scn = new Scanner(System.in);

    public void  selectAdd(Class cl) throws SQLException {
        if(cl.equals(Movie.class)){
           AdminView.getInstance().showMenuUpdateAddMovie();
        }
        if(cl.equals(Genre.class)){
            AdminView.getInstance().showMunuAddGenre();
        }
        if(cl.equals(News.class)){
            AdminView.getInstance().showMenuAddNews();
        }
        if(cl.equals(Events.class)){
            AdminView.getInstance().showMenuAddEvent();
        }
        if(cl.equals(Sesion.class)){
            AdminView.getInstance().showMenuAddSession();
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
        List<Genre> rezultGenres = new ArrayList<Genre>();
        int enter = 0;
        int lengthListGenres = AdminView.getInstance().showAllGenres();

        while(true){
            if(scn.hasNextInt()){
                enter = scn.nextInt();
                if(enter <= 0) break;
                if(enter <= lengthListGenres) rezultGenres.add(Factory.getInstance().getGenreDAO().getGenreById(enter));
                else {
                    ExceptionView.getInstance().showErrorGenreInAddMovie();
                }
            }else {
                ExceptionView.getInstance().showErrorInputString();
                scn = new Scanner(System.in);
            }
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

    public void addEvent(String name, Date dateNew, Date dateEnd, String desc) throws SQLException {
        Events event = new Events();
        event.setName(name);
        event.setDateNew(dateNew);
        event.setDateEnd(dateEnd);
        event.setDescription(desc);
        event.setMovies(allMovie());
        Factory.getInstance().getEventDAO().addEvent(event);
    }
    private List<Movie> allMovie() throws SQLException {
        System.out.println("Выбери фильмы");
        List<Movie> rezultMovies = new ArrayList<Movie>();
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovie();
        int enter = 0;

        while(true){
            System.out.println("========Фильмы=========");
            for(int i = 0; i < movies.size(); i++) {
                System.out.println("id : " + movies.get(i).getId() + ", name : " + movies.get(i).getName());
            }
            System.out.println("\nПеречислете id фильмов. Для выхода жми 0");

            if(scn.hasNextInt()){
                enter = scn.nextInt();
                if(enter <= 0) break;
                if(enter <= movies.size()) rezultMovies.add(Factory.getInstance().getMovieDAO().getMovieById(enter));
            }else {
                scn = new Scanner(System.in);
            }
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
