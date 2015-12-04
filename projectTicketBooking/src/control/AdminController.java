package control;

import dao.Factory;
import models.Genre;
import models.Movie;
import view.AdminView;
import view.ExceptionView;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private Scanner scn = new Scanner(System.in);

    public void addMovie(String name, String director, String description, Date time, Date date, String shortDescription) throws SQLException {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDirector(director);
        movie.setDescription(description);
        movie.setShortDescription(shortDescription);
        movie.setLenght(time);
        movie.setYearRelease(date);
        movie.setGenres(addGenreInMovie());

        Factory.getInstance().getMovieDAO().addMovie(movie);
    }

    private List<Genre> addGenreInMovie() throws SQLException {
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

    public void updateMovie(Movie movie) throws SQLException {
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
        movie.setGenres(addGenreInMovie());

        Factory.getInstance().getMovieDAO().updateMovie(movie);
    }

    public void addGenre(String name){
        Factory.getInstance().getGenreDAO().addGenre(new Genre(name));
    }

    public void updateGenre(Genre genre) throws SQLException {
        System.out.println("Введите название жанра ");
        genre.setName(scn.next());
        Factory.getInstance().getGenreDAO().updateGenre(genre);
    }

}
