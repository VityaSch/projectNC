package control;

import dao.Factory;
import models.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Виктор on 08.12.2015.
 */
public class EnterController {
    public EnterController(){
    }

    @Override
    public String toString(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if(str.trim().length() == 0) toString();

        return str;
    }

    public int getInt(){
        Scanner scanner = new Scanner(System.in);
        int rezult = 0;
        if(scanner.hasNextInt()){
            rezult = scanner.nextInt();
            if(rezult < 0) {
                System.out.println("Вы ввели отрицательное значение");
                getInt();
            }
        }else {
            System.out.println("Вы ввели строку, а нужно число");
            getInt();
        }
        return rezult;
    }

    public void showAllGenres(){
        try {
            List<Genre> genres = Factory.getInstance().getGenreDAO().getAllGenre();
            System.out.println("========Жанры=========");
            for(int i = 0; i < genres.size(); i++) {
                System.out.println("id : " + genres.get(i).getGenreId() + ", name : " + genres.get(i).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllMovie(){
        try {
            List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovie();
            System.out.println("========Фильмы=========");
            for(int i = 0; i < movies.size(); i++) {
                System.out.println("id : " + movies.get(i).getId() + ", name : " + movies.get(i).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllNews(){
        try {
            List<News> news = Factory.getInstance().getNewsDAO().getAllNews();
            System.out.println("========Новости=========");
            for(int i = 0; i < news.size(); i++) {
                System.out.println("id : " + news.get(i).getNewsId() + ", name : " + news.get(i).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllEvents(){
        try {
            List<Events> event = Factory.getInstance().getEventDAO().getAllEvent();
            System.out.println("========События=========");
            for(int i = 0; i < event.size(); i++) {
                System.out.println("id : " + event.get(i).getEventId() + ", name : " + event.get(i).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllSessions(){
        try {
            List<Sesion> session = Factory.getInstance().getSessionDAO().getAllSession();
            System.out.println("========Сеансы=========");
            for(int i = 0; i < session.size(); i++) {
                System.out.println("id : " + session.get(i).getSessionId() + ", name : " + session.get(i).getMovieId().getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
