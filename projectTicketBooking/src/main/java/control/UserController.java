package control;

import dao.Factory;
import models.*;
import sun.security.krb5.internal.Ticket;

import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 05.12.2015.
 */
public class UserController {
    private EnterController enter;

    public void setEnter(EnterController enter) {
        this.enter = enter;
    }
    public EnterController getEnter() {

        return enter;
    }

    public UserController(){
    }


    public List<Sesion> checkAvailableSessions() throws SQLException {
        List<Sesion> listAllSessions = Factory.getInstance().getSessionDAO().getAllSession();
        List<Sale> listAllSale = Factory.getInstance().getSaleDAO().getAllSale();
        List<Sesion> rezultListSessions = new ArrayList<Sesion>();

        for(int i = 0; i < listAllSessions.size(); i++){
            List<Tickets> listThisTickets = listAllSessions.get(i).getTicket();
            for(int j = 0; j < listAllSale.size(); j++){
                for(int l = 0; l < listThisTickets.size(); l++){
                    if(listThisTickets.get(l).getTicketId() == listAllSale.get(j).getTicket().getTicketId()){
                        listThisTickets.remove(listThisTickets.get(l));
                    }
                }
            }
            if(listThisTickets.size() > 0) {
                listAllSessions.get(i).setTicket(listThisTickets);
                rezultListSessions.add(listAllSessions.get(i));
            }
        }
        return checkBoockingSessions(rezultListSessions);
    }


    private List<Sesion> checkBoockingSessions(List<Sesion> listSessions) throws SQLException {
        List<Sesion> listAllSessions = listSessions;
        List<Sesion> rezultListSessions = new ArrayList<Sesion>();

        for(int i = 0; i < listAllSessions.size(); i++){
            List<Tickets> listThisTickets = listAllSessions.get(i).getTicket();
            List<Booking> listAllBoockings = listAllSessions.get(i).getBooking();

            for(int j = 0; j < listAllBoockings.size(); j++){
                List<Place> listPlaces = listAllBoockings.get(j).getPlaces();

                for(int l = 0; l < listThisTickets.size(); l++){
                    for(int p = 0; p < listPlaces.size(); p++){
                        if(listThisTickets.get(l).getPlaseId().getPlaceId() == listPlaces.get(p).getPlaceId()){
                            listThisTickets.remove(listThisTickets.get(l));
                        }
                    }
                }
            }
            if(listThisTickets.size() > 0) {
                listAllSessions.get(i).setTicket(listThisTickets);
                rezultListSessions.add(listAllSessions.get(i));
            }
        }
        return rezultListSessions;
    }


    public void buyTicket(Tickets ticket){
        Sale sale = new Sale();
        sale.setTicket(ticket);
        sale.setPrice(ticket.getPrice());
        sale.setDate(new Date());
        Factory.getInstance().getSaleDAO().addSale(sale);
    }

    public void boockingPlace(String name, String surname, List<Place> lp, Sesion session){
        Sesion sesion = session;
        Booking booking = new Booking();
        booking.setName(name);
        booking.setSurname(surname);
        booking.setPlaces(lp);
        booking.setSession(sesion);
        List<Booking> listTikets = sesion.getBooking();
        listTikets.add(booking);

        Factory.getInstance().getBookingDAO().addBooking(booking);
        Factory.getInstance().getSessionDAO().updateSession(sesion);
    }
}
