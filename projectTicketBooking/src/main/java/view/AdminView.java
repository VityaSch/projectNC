package view;

import control.AdminController;
import control.EnterController;
import dao.Factory;
import main.Main;
import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    ApplicationContext contextAdminView = new ClassPathXmlApplicationContext("spring-config.xml");
    AdminController adminController = null;
    EnterController enter = null;


    public void showStartAdmin() throws SQLException {
        System.out.println("Вы вошли как админ! ");
        System.out.println("С чем вы будите работать");
        System.out.println("1 - Фильмы\n2 - Жанры \n3 - Новости\n4 - События\n5 - Сеансы\n6 - Выйти");

        enter = (EnterController) contextAdminView.getBean("enter");
            switch (enter.getInt()) {
                case 1:
                    showMenu("фильм", Movie.class);
                    break;
                case 2:
                    showMenu("жанр", Genre.class);
                    break;
                case 3:
                    showMenu("новость", News.class);
                    break;
                case 4:
                    showMenu("событие", Events.class);
                    break;
                case 5:
                    showMenu("сеанс", Sesion.class);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    showStartAdmin();
                    break;
            }
    }

    private void showMenu(String name, Class cl) throws SQLException {
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");
        System.out.println("Вы находитесь в разделе " + name);
        System.out.println("1 - Добавить " + name + "\n2 - Редактировать " + name + "\n3 - Удалить " + name + "\n4 - Вернуться");

            switch (enter.getInt()){
                case 1: adminController.selectAdd(cl);
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
    }
    public void showAllGenres() throws SQLException {
        List<Genre> genres = Factory.getInstance().getGenreDAO().getAllGenre();

        for(int i = 0; i < genres.size(); i++) {
            System.out.println("id : " + genres.get(i).getGenreId() + ", name : " + genres.get(i).getName());
        }
        System.out.println("\nПеречислете id жаров. Для выхода жми 0");
    }
    public void showAllMovie() throws SQLException {
        List<Movie> movies = Factory.getInstance().getMovieDAO().getAllMovie();
        System.out.println("========Фильмы=========");
        for(int i = 0; i < movies.size(); i++) {
            System.out.println("id : " + movies.get(i).getId() + ", name : " + movies.get(i).getName());
        }

    }

    public void showMenuUpdateAddMovie() throws SQLException {
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");
        System.out.println("Введите название фильма ");
        String name = enter.toString();

        System.out.println("Введите режисера");
        String director = enter.toString();

        System.out.println("Введите описание");
        String description = enter.toString();

        System.out.println("Введите краткое описание");
        String shortDescription = enter.toString();

        System.out.println("Введите год релиза");
        int yyyy = enter.getInt();

        System.out.println("Введите месяц релиза");
        int mm = enter.getInt();

        System.out.println("Введите день релиза");
        int dd = enter.getInt();

        System.out.println("Введите продолжительность фильма");
        System.out.println("Введите час");
        int hh = enter.getInt();

        System.out.println("Введите минуты");
        int mi = enter.getInt();

        Date date = new Date((yyyy-1900),(mm-1),dd,hh,mi,00);
        adminController.addMovie(name,director,description,date,date,shortDescription);
        showStartAdmin();
    }
    public void showMunuAddGenre(){
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");
        System.out.println("Введите название жанра");
        String name = enter.toString();
        adminController.addGenre(name);
    }
    public void showMenuAddNews() throws SQLException {
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");
        System.out.println("Введите название");
        String name = enter.toString();
        System.out.println("Введите описание");
        String desc = enter.toString();

        showAllMovie();
        System.out.println("Выбери фильм");
        int movieId = enter.getInt();

        if(movieId > 0 && movieId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
            adminController.addNews(Factory.getInstance().getMovieDAO().getMovieById(movieId),name,desc,new Date());
        }
    }
    public void showMenuAddEvent() throws SQLException {
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");
        int yyyy, mm, dd, discount;

        System.out.println("Введите название");
        String name = enter.toString();

        System.out.println("Введите описание");
        String desc = enter.toString();

        System.out.println("Введите скидку");
        discount = enter.getInt();

        System.out.println("Введите дату начала");
        System.out.println("Год");
        yyyy = enter.getInt();

        System.out.println("Месяц");
        mm = enter.getInt();

        System.out.println("День");
        dd = enter.getInt();
        Date dateNew = new Date(yyyy,mm,dd);

        System.out.println("Выбери дату окончания");
        System.out.println("Год");
        yyyy = enter.getInt();

        System.out.println("Месяц");
        mm = enter.getInt();

        System.out.println("День");
        dd = enter.getInt();
        Date dateEnd = new Date(yyyy,mm,dd);

        adminController.addEvent(name,dateNew,dateEnd,desc,discount);
    }
    public void showMenuAddSession() throws SQLException {
        adminController = (AdminController) contextAdminView.getBean("adminController");
        enter = (EnterController) contextAdminView.getBean("enter");

        System.out.println("Введите дату сеанса");
        System.out.println("Введите год");
        int yyyy = enter.getInt();

        System.out.println("Введите месяц");
        int mm = enter.getInt();

        System.out.println("Введите день");
        int dd = enter.getInt();

        System.out.println("Введите время сеанса");
        System.out.println("Введите час");
        int hh =  enter.getInt();

        System.out.println("Введите минуты");
        int mi =  enter.getInt();

        System.out.println("Введите цену");
        int price =  enter.getInt();

        adminController.addSession(selectMovie(),selectHall(),new Date(yyyy,mm,dd,hh,mi,00),price);
    }
    private Movie selectMovie() throws SQLException {
        enter = (EnterController) contextAdminView.getBean("enter");
        showAllMovie();

        System.out.println("Выбери фильм");
        int movieId = enter.getInt();
        if(movieId > 0 && movieId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
            return Factory.getInstance().getMovieDAO().getMovieById(movieId);
        }else selectMovie();

        return null;
    }
    private Hall selectHall() throws SQLException {
        List<Hall> halls = Factory.getInstance().getHallDAO().getAllHall();
        enter = (EnterController) contextAdminView.getBean("enter");

        for(int i = 0; i < halls.size(); i++) {
            System.out.println("id : " + halls.get(i).getHallId() );
        }
        System.out.println("Выбери зал");

        int hallId = enter.getInt();
        if(hallId > 0 && hallId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
            return Factory.getInstance().getHallDAO().getHallById(hallId);
        }
        return null;
    }
}
