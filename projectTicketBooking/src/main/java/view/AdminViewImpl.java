package view;

import control.AdminController;
import control.EnterController;
import dao.Factory;
import models.*;
import view.interfac.ViewAdmin;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class AdminViewImpl implements ViewAdmin {
    private AdminController adminController;
    private EnterController enter;

    public AdminViewImpl(){
    }

    public AdminController getAdminController() {
        return adminController;
    }
    public EnterController getEnter() {
        return enter;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }

    public void showStartAdmin() {
        System.out.println("Вы вошли как админ! ");
        System.out.println("С чем вы будите работать");
        System.out.println("1 - Фильмы\n2 - Жанры \n3 - Новости\n4 - События\n5 - Сеансы\n6 - Выйти");

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
                case 6: System.exit(0);
                    break;
                default:
                    showStartAdmin();
                    break;
            }
    }

    private void showMenu(String name, Class cl)  {
        System.out.println("Вы находитесь в разделе " + name);
        System.out.println("1 - Добавить " + name + "\n2 - Редактировать " + name + "\n3 - Вернуться");

            switch (enter.getInt()){
                case 1: selectAddUpdate(cl,true);
                    break;
                case 2: selectAddUpdate(cl,false);
                    break;
                case 3: showStartAdmin();
                    break;
                default: showMenu(name,cl);
                    break;
            }
    }

    private void  selectAddUpdate(Class cl, boolean add){
        if(cl.equals(Movie.class)){
            if(add)showMenuUpdateAddMovie(true);
            else showMenuUpdateAddMovie(false);
        }
        if(cl.equals(Genre.class)){
            if(add)showMunuUpdateAddGenre(true);
            else showMunuUpdateAddGenre(false);
        }
        if(cl.equals(News.class)){
            if(add)showMenuUpdateAddNews(true);
            else showMenuUpdateAddNews(false);
        }
        if(cl.equals(Events.class)){
            if(add)showMenuUpdateAddEvent(true);
            else showMenuUpdateAddEvent(false);

        }
        if(cl.equals(Sesion.class)){
            if(add)showMenuUpdateAddSession(true);
            else showMenuUpdateAddSession(false);
        }
    }


    private void showMenuUpdateAddMovie(boolean add){
        Movie movie = null;
        if(!(add)) {
            System.out.println("Редактирование");
            movie = selectMovie();
        }else {
            System.out.println("Добавление");
            movie = new Movie();
        }


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

        adminController.addMovie(movie,name,director,description,date,date,shortDescription,add);
        showStartAdmin();
    }
    private void showMunuUpdateAddGenre(boolean add){
        Genre genre;
        if(!(add)) {
            System.out.println("Редактирование");
            genre = selectGenre();
        }else{
            System.out.println("Добавление");
            genre = new Genre();
        }
        System.out.println("Введите название жанра");
        String name = enter.toString();
        adminController.addGenre(genre,add,name);
        showStartAdmin();
    }
    private void showMenuUpdateAddNews(boolean add){
        News news;
        if(!(add)){
            System.out.println("Редактирование");
            news = selectNews();
        }else{
            System.out.println("Добавление");
            news = new News();
        }
        System.out.println("Введите название");
        String name = enter.toString();
        System.out.println("Введите описание");
        String desc = enter.toString();

        adminController.addNews(news,add,selectMovie(),name,desc,new Date());
        showStartAdmin();
    }
    private void showMenuUpdateAddEvent(boolean add){
        Events event;
        if(!(add)){
            System.out.println("Редактирование");
            event = selectEvents();
        }else{
            System.out.println("Добавление");
            event = new Events();
        }
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

        adminController.addEvent(event,add,name,dateNew,dateEnd,desc,discount);
        showStartAdmin();
    }
    private void showMenuUpdateAddSession(boolean add){
        Sesion session;
        if(!(add)){
            System.out.println("Редактирование");
            session = selectSesions();
        }else{
            System.out.println("Добавление");
            session = new Sesion();
        }
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

        try {
            adminController.addSession(session,add,selectMovie(),selectHall(),new Date(yyyy,mm,dd,hh,mi,00),price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showStartAdmin();
    }

    private Movie selectMovie(){
        try {
            enter.showAllMovie();
            System.out.println("Выбери фильм");
            int movieId = enter.getInt();
            if(movieId > 0 && movieId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                return Factory.getInstance().getMovieDAO().getMovieById(movieId);
            }else selectMovie();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Genre selectGenre(){
        enter.showAllGenres();
        System.out.println("Выбери жанр");
        int genreId = enter.getInt();
        try {
            if(genreId > 0 && genreId <= Factory.getInstance().getGenreDAO().getAllGenre().size()){
                return Factory.getInstance().getGenreDAO().getGenreById(genreId);
            }else selectGenre();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private News selectNews(){
        try {
            enter.showAllNews();
            System.out.println("Выбери новость");
            int newsId = enter.getInt();
            if(newsId > 0 && newsId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                return Factory.getInstance().getNewsDAO().getNewsById(newsId);
            }else selectNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Events selectEvents(){
        try {
            enter.showAllEvents();
            System.out.println("Выбери событие");
            int eventId = enter.getInt();
            if(eventId > 0 && eventId <= Factory.getInstance().getEventDAO().getAllEvent().size()){
                return Factory.getInstance().getEventDAO().getEventById(eventId);
            }else selectEvents();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Sesion selectSesions(){
        try {
            enter.showAllSessions();
            System.out.println("Выбери сеанс");
             int sessionId = enter.getInt();
            if(sessionId > 0 && sessionId <= Factory.getInstance().getSessionDAO().getAllSession().size()){
                return Factory.getInstance().getSessionDAO().getSessionById(sessionId);
            }else selectSesions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Hall selectHall(){
        try {
            List<Hall> halls = Factory.getInstance().getHallDAO().getAllHall();
            for(int i = 0; i < halls.size(); i++) {
                System.out.println("id : " + halls.get(i).getHallId() );
            }
            System.out.println("Выбери зал");

            int hallId = enter.getInt();
            if(hallId > 0 && hallId <= Factory.getInstance().getMovieDAO().getAllMovie().size()){
                return Factory.getInstance().getHallDAO().getHallById(hallId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
