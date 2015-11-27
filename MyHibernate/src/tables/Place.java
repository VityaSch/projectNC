package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PLACES")
public class Place {
	public Place(){
	}
	
	@Id
	@Column(name="PLACE_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int place_id;
	
	@ManyToOne
	@JoinColumn(name="HALL_ID")
	private Hall hallPlace;
	
	@Column(name="row")
	private int row;
	
	@Column(name="NUMBER_PLACE")
	private int numberPlace;
	
	public int getPlaceId(){
		return this.place_id;
	}
	
	public Hall getHall(){
		return this.hallPlace;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getNumberPlace(){
		return this.numberPlace;
	}

	public void setPlaceId(int id){
		this.place_id = id;
	}
	
	public void setHall(Hall h){
		this.hallPlace = h;
	}
	
	public void setRow(int r){
		this.row = r;
	}
	
	public void setNumberPlace(int np){
		this.numberPlace = np;
	}
}
