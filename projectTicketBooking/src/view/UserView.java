package view;

import dao.Factory;
import models.Movie;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Виктор on 04.12.2015.
 */
public class UserView {
    private static UserView userView = null;

    public static synchronized UserView getInstance(){
        if (userView == null){
            userView = new UserView();
        }
        return userView;
    }

    public void showAllMovie() throws SQLException {
        List<Movie> genres = Factory.getInstance().getMovieDAO().getAllMovie();
        System.out.println("========Фильмы=========");
        for(int i = 0; i < genres.size(); i++) {
            System.out.println("id : " + genres.get(i).getId() + ", name : " + genres.get(i).getName());
        }
    }
}
