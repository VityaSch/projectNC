package view;

import dao.Factory;
import models.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public int showAllGenres() throws SQLException {
        List<Genre> genres = Factory.getInstance().getGenreDAO().getAllGenre();

        for(int i = 0; i < genres.size(); i++) {
            System.out.println("id : " + genres.get(i).getGenreId() + ", name : " + genres.get(i).getName());
        }
        System.out.println("\nПеречислете id жаров. Для выхода жми 0");

        return genres.size();
    }

    public void showMenuUpdateMovie() throws SQLException {
        UserView.getInstance().showAllMovie();
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
    }
}
