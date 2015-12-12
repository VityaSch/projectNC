package models;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TICKETS")
public class Tickets {
	public Tickets(){}
	
	public Tickets(Sesion s, Place p, Date d, int pr){
		this.ticketSession = s;
		this.place = p;
		this.date = d;
		this.price = pr;
	}
	
	@Id
	@Column(name="TICKET_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int ticketId;

	@ManyToOne
	@JoinColumn(name="SESSION_ID")
	private Sesion ticketSession;
	
	@OneToOne
	@JoinColumn(name="PLACE_ID")
	private Place place;
	
	@Column(name="DATE_TIME")
	private Date date;
	
	@Column(name="PRICE")
	private int price;
	
	public int getTicketId(){
		return this.ticketId;
	}
	
	public Sesion getSessionId(){
		return ticketSession;
	}
	
	public Place getPlaseId(){
		return this.place;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setTicketId(int id){
		this.ticketId = id;
	}
	
	public void setSessionId(Sesion s){
		this.ticketSession = s;
	}
	
	public void setPlaceId(Place p){
		this.place = p;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
	
	public void setPrice(int p){
		this.price = p;
	}
	
	
	
}
