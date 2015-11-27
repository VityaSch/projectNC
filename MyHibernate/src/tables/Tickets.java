package tables;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TICKETS")
public class Tickets {
	public Tickets(){
	}
	
	@Id
	@Column(name="TICKET_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int ticket_id;
	
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
		return this.ticket_id;
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
		this.ticket_id = id;
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
