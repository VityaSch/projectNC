package view;

import control.UserController;
import dao.Factory;
import models.Movie;
import models.Sesion;
import models.Tickets;
import view.interfac.ViewUser;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Виктор on 04.12.2015.
 */
public class UserViewImpl implements ViewUser {
    private List<Sesion> listAllSesion;

    public UserViewImpl(){
    }

    public void showStartUser(){
        System.out.println("Вы вошли как пользователь! ");
        System.out.println("1 - Показать все сеансы\n2 - Показать сеансы на определенный день \n3 - Забронировать места\n4 - Купить билеты ");
        Scanner scn = new Scanner(System.in);
        if(scn.hasNextInt()){
            switch (scn.nextInt()){
                case 1: showAllSession();
                    break;
                case 2: showSessionOnDay();
                    break;
                case 3:
                    break;
                case 4: showBuyTicket();
                    break;
                default: showStartUser();
                    break;
            }
        } else showStartUser();
    }

    private void showAllSession(){
        try {
            SimpleDateFormat ft = new SimpleDateFormat ("MM.dd.yyyy hh:mm");
            List<Sesion> listAllSesion = Factory.getInstance().getSessionDAO().getAllSession();
            System.out.println("Сеанс\t\tФильм\t\tЗал\t\tДата");
            for(int i = 0; i < listAllSesion.size(); i++) {
                System.out.println(listAllSesion.get(i).getSessionId() + "\t\t\t" + listAllSesion.get(i).getMovieId().getName() +
                        "\t\t" + listAllSesion.get(i).getHallId().getHallId() + "\t\t" + ft.format(listAllSesion.get(i).getDate()));
            }
            showStartUser();
        } catch (SQLException e) {
            System.err.println("Error session");
        }
    }

    private void showSessionOnDay(){
        System.out.println("Введите дату месяц и день");
        SimpleDateFormat ft = new SimpleDateFormat ("MM.dd");
        Scanner scn = new Scanner(System.in);
        String date = scn.next();
        try {
            listAllSesion = Factory.getInstance().getSessionDAO().getAllSession();
            System.out.println("Сеанс\t\tФильм\t\tЗал\t\tДата");
            for(int i = 0; i < listAllSesion.size(); i++) {
                if(date.equals(ft.format(listAllSesion.get(i).getDate()))) {
                    System.out.println(listAllSesion.get(i).getSessionId() + "\t\t" +listAllSesion.get(i).getMovieId().getName() +
                            "\t\t" + listAllSesion.get(i).getHallId().getHallId() + "\t\t" + ft.format(listAllSesion.get(i).getDate()));
                }
            }
            showStartUser();
        } catch (SQLException e) {
            System.err.println("Error session");
        }
    }

    private void showBuyTicket(){
        System.out.println("Выберите сеанс");
        Scanner scn = new Scanner(System.in);
        try {
            listAllSesion = Factory.getInstance().getSessionDAO().getAllSession();
            if(scn.hasNextInt()){
                int sessionId = scn.nextInt();
                if(sessionId <= listAllSesion.size() && sessionId >=0){
                   new UserController().definePlace(Factory.getInstance().getSessionDAO().getSessionById(sessionId));
                    List<Tickets> listThisSessionTickets = Factory.getInstance().getSessionDAO().getSessionById(sessionId).getTicket();
                    System.out.println("Билет\t\tРяд\t\tМесто\t\tЦена");
                    for(int i=0;i<listThisSessionTickets.size();i++){
                        System.out.println(listThisSessionTickets.get(i).getTicketId()  + "\t\t" + listThisSessionTickets.get(i).getPlaseId().getRow() +
                                "\t\t" + listThisSessionTickets.get(i).getPlaseId().getNumberPlace() + "\t\t" + listThisSessionTickets.get(i).getPrice());
                    }
                    System.out.println("Выберите билет");
                    if(scn.hasNextInt()){
                        int ticketId = scn.nextInt();
                        if(ticketId > listThisSessionTickets.size() && ticketId < 0){
                           new UserController().buyTicket(Factory.getInstance().getTicketsDAO().getTicketsById(ticketId));
                        }else showBuyTicket();
                    }else showBuyTicket();
                } else showBuyTicket();
            }else showBuyTicket();
            showStartUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
