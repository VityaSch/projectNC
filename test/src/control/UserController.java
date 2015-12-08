package control;

import dao.Factory;
import models.*;
import sun.security.krb5.internal.Ticket;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 05.12.2015.
 */
public class UserController {
    public void definePlace(Sesion sesion){
        List<Tickets> listRezultTicketThisSession = new ArrayList<Tickets>();
        List<Tickets> listAllTiketsThisSession = sesion.getTicket();
        List<Booking> listAllBookingThisSession = sesion.getBooking();
        List<Place> listPlaceInBooking;

        for(int i=0; i<listAllTiketsThisSession.size();i++){
            for(int j=0; j<listAllBookingThisSession.size();j++){
                listPlaceInBooking = listAllBookingThisSession.get(j).getPlaces();
                for(int k=0; k<listPlaceInBooking.size();k++){
                    if(listAllTiketsThisSession.get(i).getPlaseId().getPlaceId() != listPlaceInBooking.get(k).getPlaceId()){
                        listRezultTicketThisSession.add(listAllTiketsThisSession.get(i));
                    }
                }
            }
        }
        sesion.setTicket(listRezultTicketThisSession);
        Factory.getInstance().getSessionDAO().updateSession(sesion);
    }
    public void buyTicket(Tickets ticket){
        Sesion thisSesion = ticket.getSessionId();
        List<Tickets> listAllTicketInSession = thisSesion.getTicket();
        listAllTicketInSession.remove(ticket);
        thisSesion.setTicket(listAllTicketInSession);
        Factory.getInstance().getSessionDAO().updateSession(thisSesion);
        Sale sale = new Sale(ticket,new Date(1),ticket.getPrice());
        Factory.getInstance().getSaleDAO().addSale(sale);
    }
}
