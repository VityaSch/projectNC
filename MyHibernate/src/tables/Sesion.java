package tables;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SESSIONS")
public class Sesion {
	public Sesion(){
	}
	@Id
	@Column(name="SESSION_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int session_id;
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private Movie movieSession;
		
	@ManyToOne
	@JoinColumn(name="HALL_ID")
	private Hall hallSession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketSession")
	private List<Tickets> ticket;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingSession")
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
		return this.session_id;
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
		this.session_id = id;
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
