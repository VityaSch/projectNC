package tables;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BOOKINGS")
public class Booking {
	public Booking(){
	}
	
	@Id
	@Column(name="BOOKING_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int booking_id;
	
	@ManyToOne
	@JoinColumn(name="SESSION_ID")
	private Sesion bookingSession;
	
	@ManyToMany
	@JoinTable(
			name="PLACES_BOOKINGS",
			joinColumns = {@JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID")},
			inverseJoinColumns = {@JoinColumn(name = "PLACE_ID", referencedColumnName = "PLACE_ID")})
	private List<Place> places;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="NAME")
	private String name;
	
	public List<Place> getPlaces(){
		return this.places;
	}
	
	public int getBookingId(){
		return this.booking_id;
	}
	
	public Sesion getSession(){
		return this.bookingSession;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
	public String getName(){
		return this.name;
	}

	public void setBookingId(int id){
		this.booking_id = id;
	}
	
	public void setSession(Sesion s){
		this.bookingSession = s;
	}
	
	public void setSurname(String sn){
		this.surname = sn;
	}
	
	public void setName(String n){
		this.name = n;
	}

	public void setPlaces(List<Place> lp){
		this.places = lp;
	}
}
