package dao;

import impl.BookingDAOImpl;
import impl.EventDAOImpl;
import impl.GenreDAOImpl;
import impl.HallDAOImpl;
import impl.MovieDAOImpl;
import impl.NewsDAOImpl;
import impl.PlaceDAOImpl;
import impl.SaleDAOImpl;
import impl.SessionDAOImpl;
import impl.TicketsDAOImpl;
import models.News;

public class Factory {
	private static MovieDAO movieDAO = null;
	private static GenreDAO genreDAO = null;
	private static EventDAO eventDAO = null;
	private static NewsDAO newsDAO = null;
	private static BookingDAO bookingDAO = null;
	private static HallDAO hallDAO = null;
	private static PlaceDAO placeDAO = null;
	private static SaleDAO saleDAO = null;
	private static SessionDAO sessionDAO = null;
	private static TicketsDAO ticketDAO = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance(){
          if (instance == null){
            instance = new Factory();
          }
          return instance;
    }
	
	public MovieDAO getMovieDAO(){
        if (movieDAO == null){
        	movieDAO = new MovieDAOImpl();
        }
        return movieDAO;
	}   
	
	public GenreDAO getGenreDAO(){
        if (genreDAO == null){
        	genreDAO = new GenreDAOImpl();
        }
        return genreDAO;
	}   
	
	public EventDAO getEventDAO(){
		if(eventDAO == null){
			eventDAO = new EventDAOImpl();
		}
		return eventDAO;
	}
	
	public NewsDAO getNewsDAO(){
		if(newsDAO == null){
			newsDAO = new NewsDAOImpl();
		}
		return newsDAO;
	}
	
	public BookingDAO getBookingDAO(){
		if(bookingDAO == null){
			bookingDAO = new BookingDAOImpl();
		}
		return bookingDAO;
	}
	
	public HallDAO getHallDAO(){
		if(hallDAO == null){
			hallDAO = new HallDAOImpl();
		}
		return hallDAO;
	}
	
	public PlaceDAO getPlaceDAO(){
		if(placeDAO == null){
			placeDAO = new PlaceDAOImpl();
		}
		return placeDAO;
	}
	
	public SaleDAO getSaleDAO(){
		if(saleDAO == null){
			saleDAO = new SaleDAOImpl();
		}
		return saleDAO;
	}
	
	public SessionDAO getSessionDAO(){
		if(sessionDAO == null){
			sessionDAO = new SessionDAOImpl();
		}
		return sessionDAO;
	}
 
	public TicketsDAO getTicketsDAO(){
		if(ticketDAO == null){
			ticketDAO = new TicketsDAOImpl();
		}
		return ticketDAO;
	}
}
