package view;

import control.AdminController;
import dao.Factory;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Виктор on 03.12.2015.
 */
public class AdminView {
    private static AdminView adminView = null;
    private Scanner scn = new Scanner(System.in);

    public static synchronized AdminView getInstance(){
        if (adminView == null){
            adminView = new AdminView();
        }
        return adminView;
    }
    public void showStartAdmin() throws SQLException {
        System.out.println("Вы вошли как админ! ");
        System.out.println("1 - Фильмы\n2 - Жанры \n3 - Новости\n4 - События\n5 - Сеансы");
        Scanner scn = new Scanner(System.in);
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1: showMenu("фильмов",Movie.class);
                    break;
                case 2: showMenu("жанров", Genre.class);
                    break;
                case 3: showMenu("новостей", News.class);
                    break;
                case 4: showMenu("событий", Events.class);
                    break;
                case 5: showMenu("сеансов", Sesion.class);
                    break;
                default: showStartAdmin();
                    break;
            }
        } else showStartAdmin();
    }

    private void showMenu(String name, Class cl) throws SQLException {
        System.out.println("Меню " + name);
        System.out.println("1 - Добавить\n2 - Редактировать \n3 - Удалить\n4 - Вернуться");
        Scanner scn = new Scanner(System.in);
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1: new AdminController().selectAdd(cl);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:showStartAdmin();
                    break;
                default: showMenu(name,cl);
                    break;
            }
        } else showMenu(name,cl);
    }

    public int showAllGenres() throws SQLException {
        List<Genre> genres = Factory.getInstance().getGenreDAO().getAllGenre();

        for(int i = 0; i < genres.size(); i++) {
            System.out.println("id : " + genres.get(i).getGenreId() + ", name : " + genres.get(i).getName());
        }
        System.out.println("\nПеречислете id жаров. Для выхода жми 0");

        return genres.size();
    }

    public void showMenuUpdateAddMovie() throws SQLException {
        System.out.println("Введите название фильма ");
        String name = scn.next();
        System.out.println("Введите режисера");
        String director = scn.next();
        System.out.println("Введите описание");
        String description = scn.next();
        System.out.println("Введите краткое описание");
        String shortDescription = scn.next();
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
        Date date = new Date((yyyy-1900),(mm-1),dd,hh,mi,00);
        new AdminController().addMovie(name,director,description,date,date,shortDescription);
    }
    public void showMunuAddGenre(){
        System.out.println("Введите название жанра");
        String name = scn.next();
        new AdminController().addGenre(name);
    }
    public void showMenuAddNews() throws SQLException {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovie();
        System.out.println("Введите название");
        String name = scn.next();
        System.out.println("Введите описание");
        String desc = scn.next();
        System.out.println("========Фильмы=========");
        for(int i = 0; i < movies.size(); i++) {
            System.out.println("id : " + movies.get(i).getId() + ", name : " + movies.get(i).getName());
        }
        System.out.println("Выбери фильм");
        if(scn.hasNextInt()){
            int movieId = scn.nextInt();
            if(movieId > 0 && movieId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                new AdminController().addNews(Factory.getInstance().getMovieDAO().getMovieById(movieId),name,desc,new Date());
            }
        }else{
            scn = new Scanner(System.in);
            showMenuAddNews();
        }
    }
    public void showMenuAddEvent() throws SQLException {
        int yyyy, mm, dd;
        System.out.println("Введите название");
        String name = scn.next();
        System.out.println("Введите дату начала");
        System.out.println("Год");
        if(scn.hasNextInt()){
            yyyy = scn.nextInt();
            System.out.println("Месяц");
            mm = scn.nextInt();
            System.out.println("День");
            dd = scn.nextInt();
            Date dateNew = new Date(yyyy,mm,dd);

            System.out.println("Выбери дату окончания");
            System.out.println("Год");
            yyyy = scn.nextInt();
            System.out.println("Месяц");
            mm = scn.nextInt();
            System.out.println("День");
            dd = scn.nextInt();
            Date dateEnd = new Date(yyyy,mm,dd);

            System.out.println("Введите скидку");
            String desc = scn.next();

            new AdminController().addEvent(name,dateNew,dateEnd,desc);
        }else{
            scn = new Scanner(System.in);
            showMenuAddEvent();
        }
    }
    public void showMenuAddSession() throws SQLException {
        System.out.println("Введите дату сеанса");
        System.out.println("Введите год");
        if(scn.hasNextInt()){
            int yyyy = scn.nextInt();
            System.out.println("Введите месяц");
            int mm = scn.nextInt();
            System.out.println("Введите день");
            int dd = scn.nextInt();
            System.out.println("Введите время сеанса");
            System.out.println("Введите час");
            int hh = scn.nextInt();
            System.out.println("Введите минуты");
            int mi = scn.nextInt();
            System.out.println("Введите цену");
            int price = scn.nextInt();

            new AdminController().addSession(selectMovie(),selectHall(),new Date(yyyy,mm,dd,hh,mi,00),price);
        }else{
            scn = new Scanner(System.in);
            showMenuAddSession();
        }
    }
    private Movie selectMovie() throws SQLException {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovie();

        for(int i = 0; i < movies.size(); i++) {
            System.out.println("id : " + movies.get(i).getId() + ", name : " + movies.get(i).getName());
        }
        System.out.println("Выбери фильм");

        if(scn.hasNextInt()){
            int movieId = scn.nextInt();
            if(movieId > 0 && movieId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                return Factory.getInstance().getMovieDAO().getMovieById(movieId);
            }else selectMovie();
        }else{
            scn = new Scanner(System.in);
            selectMovie();
        }
        return null;
    }
    private Hall selectHall() throws SQLException {
        List<Hall> halls = Factory.getInstance().getHallDAO().getAllHall();

        for(int i = 0; i < halls.size(); i++) {
            System.out.println("id : " + halls.get(i).getHallId() );
        }
        System.out.println("Выбери зал");

        if(scn.hasNextInt()){
            int hallId = scn.nextInt();
            if(hallId > 0 && hallId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                return Factory.getInstance().getHallDAO().getHallById(hallId);
            }
        }else{
            scn = new Scanner(System.in);
            selectHall();
        }
        return null;
    }
}
