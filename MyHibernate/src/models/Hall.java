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
		this.count_place = cp;
		this.count_row = cr;
		this.session = ls;
		this.places = lp;
	}
	
	@Id
	@Column(name="HALL_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int hall_id;
	
	@Column(name="COUNT_PLACE")
	private int count_place;
	
	@Column(name="COUNT_ROW")
	private int count_row;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hallSession")
	private List<Sesion> session;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hallPlace")
	private List<Place> places;
	
	public int getHallId(){
		return this.hall_id;
	}
	
	public int getCountPlace(){
		return this.count_place;
	}
	
	public int getCountRow(){
		return this.count_row;
	}
	
	public List<Sesion> getSession(){
		return this.session;
	}
	
	public List<Place> getHalls(){
		return this.places;
	}
	
	public void setHallId(int id){
		this.hall_id = id;
	}
	
	public void setCountPlace(int cp){
		this.count_place = cp;
	}
	
	public void setCountRow(int cr){
		this.count_row = cr;
	}
	
	public void setSession(List<Sesion> ls){
		this.session = ls;
	}
	
	public void setHall(List<Place> lh){
		this.places = lh;
	}
}
