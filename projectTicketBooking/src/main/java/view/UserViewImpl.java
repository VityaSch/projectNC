package view;

import control.EnterController;
import control.UserController;
import dao.Factory;
import models.*;
import view.interfac.ViewUser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UserViewImpl implements ViewUser {
    private EnterController enter;
    private UserController userController;


    public UserViewImpl(){
    }

    public void showStartUser(){
        System.out.println("Вы вошли как пользователь! ");
        System.out.println("\n1 - Показать все сеансы\n2 - Показать сеансы на определенный день \n3 - Выйти");
        switch (enter.getInt()){
            case 1: showAllSession();
                break;
            case 2: showSessionOnDay();
                break;
            case 3: System.exit(0);
                break;
            default: showStartUser();
                break;
        }
    }

    private void showMenu(){
        System.out.println("\n1 - Купить билет\n2 - Забронировать место\n3 - вернуться\n");
        switch (enter.getInt()){
            case 1: showBuyTicket();
                break;
            case 2: showBoocking();
                break;
            case 3: showStartUser();
                break;
            default: showMenu();
                break;
        }
    }

    private void showAllSession(){
        try {
            SimpleDateFormat ft = new SimpleDateFormat ("MM.dd.yyyy hh:mm");
            List<Sesion> listAllSesion = userController.checkAvailableSessions();
            System.out.println("Сеанс\t\tФильм\t\tЗал\t\tДата");
            for(int i = 0; i < listAllSesion.size(); i++) {
                System.out.println(listAllSesion.get(i).getSessionId() + "\t\t\t" + listAllSesion.get(i).getMovieId().getName() +
                        "\t\t" + listAllSesion.get(i).getHallId().getHallId() + "\t\t" + ft.format(listAllSesion.get(i).getDate()));
            }
            showMenu();
        } catch (SQLException e) {
            System.err.println("Error session");
        }
    }

    private void showSessionOnDay(){
        System.out.println("\nВведите дату месяц и день");
        SimpleDateFormat ft = new SimpleDateFormat ("MM.dd");

        String date = enter.toString();
        try {
            List<Sesion> listAllSesion = userController.checkAvailableSessions();
            System.out.println("Сеанс\t\tФильм\t\tЗал\t\tДата");
            for(int i = 0; i < listAllSesion.size(); i++) {
                if(date.equals(ft.format(listAllSesion.get(i).getDate()))) {
                    System.out.println(listAllSesion.get(i).getSessionId() + "\t\t" +listAllSesion.get(i).getMovieId().getName() +
                            "\t\t" + listAllSesion.get(i).getHallId().getHallId() + "\t\t" + ft.format(listAllSesion.get(i).getDate()));
                }
            }
            showMenu();
        } catch (SQLException e) {
            System.err.println("Error session");
        }
    }

    private void showBuyTicket(){
        try {
            List<Tickets> listTickets = selectPlace();
            System.out.println("\nВыберите местo");
            int placeId = enter.getInt();
            if (placeId > 0 && placeId <= listTickets.size()) userController.buyTicket(Factory.getInstance().getTicketsDAO().getTicketsById(placeId));
            else showBuyTicket();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            showStartUser();
        }
    }

    private void showBoocking(){
        System.out.println("Введите ваше имя");
        String name = enter.toString();

        System.out.println("Введите вашу фамилию");
        String surname = enter.toString();

        List<Tickets> listTickets = selectPlace();
        System.out.println("\nВыберите местa");

        List<Place> rezultPlaces = new ArrayList<Place>();
        while(true){
            int e = enter.getInt();
            if(e <= 0) break;
            if(e > 0 && e <= listTickets.size()){
                rezultPlaces.add(listTickets.get(e).getPlaseId());
            }else showBoocking();
        }
        userController.boockingPlace(name,surname,rezultPlaces,listTickets.get(0).getSessionId());
        showStartUser();
    }

    private List<Tickets> selectPlace(){
        try {
            List<Sesion> listAllSesion = userController.checkAvailableSessions();
            System.out.println("\nВыберите сеанс");
            int movieId = enter.getInt();
            if (movieId > 0 && movieId <= listAllSesion.size()) {
                List<Tickets> listTickets = listAllSesion.get(movieId - 1).getTicket();
                for (int i = 0; i < listTickets.size(); i++) {
                    System.out.println("id = " + i + " место = " + listTickets.get(i).getPlaseId().getNumberPlace() + " ряд = " + listTickets.get(i).getPlaseId().getRow());
                }
                return listTickets;
            }selectPlace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EnterController getEnter() {
        return enter;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
