package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HALLS")
public class Hall {
	public Hall(){}
	
	public Hall(int cp, int cr, List<Sesion> ls, List<Place> lp){
		this.countPlace = cp;
		this.countRow = cr;
		this.session = ls;
		this.places = lp;
	}
	
	@Id
	@Column(name="HALL_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int hallId;
	
	@Column(name="COUNT_PLACE")
	private int countPlace;
	
	@Column(name="COUNT_ROW")
	private int countRow;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hallSession")
	private List<Sesion> session;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hallPlace")
	private List<Place> places;
	
	public int getHallId(){
		return this.hallId;
	}
	
	public int getCountPlace(){
		return this.countPlace;
	}
	
	public int getCountRow(){
		return this.countRow;
	}
	
	public List<Sesion> getSession(){
		return this.session;
	}
	
	public List<Place> getHalls(){
		return this.places;
	}
	
	public void setHallId(int id){
		this.hallId = id;
	}
	
	public void setCountPlace(int cp){
		this.countPlace = cp;
	}
	
	public void setCountRow(int cr){
		this.countRow = cr;
	}
	
	public void setSession(List<Sesion> ls){
		this.session = ls;
	}
	
	public void setHall(List<Place> lh){
		this.places = lh;
	}
}
