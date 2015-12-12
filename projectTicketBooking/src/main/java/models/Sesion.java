package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SESSIONS")
public class Sesion {
	public Sesion(){}
	
	public Sesion(Movie m, Hall h, List<Tickets> lt, List<Booking> lb, Date d){
		this.movieSession = m;
		this.hallSession = h;
		this.ticket = lt;
		this.booking = lb;
		this.date = d;
	}	
	
	@Id
	@Column(name="SESSION_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int sessionId;
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private Movie movieSession;
		
	@ManyToOne
	@JoinColumn(name="HALL_ID")
	private Hall hallSession;
	
	@OneToMany
	private List<Tickets> ticket;
	
	@OneToMany
	private List<Booking> booking;
	
	@Column(name="DATE_TIME")
	private Date date;
	
	public List<Tickets> getTicket(){
		return this.ticket;
	}
	
	public List<Booking> getBooking(){
		return this.booking;
	}
	
	public int getSessionId(){
		return this.sessionId;
	}
	
	public Movie getMovieId(){
		return this.movieSession;
	}
	
	public Hall getHallId(){
		return this.hallSession;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void setSessionId(int id){
		this.sessionId = id;
	}
	
	public void setMovieId(Movie m){
		this.movieSession = m;
	}
	
	public void setHallId(Hall h){
		this.hallSession = h;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
	
	public void setTicket(List<Tickets> tic){
		this.ticket = tic;
	}
	
	public void setBooking(List<Booking> boo){
		this.booking = boo;
	}
}
