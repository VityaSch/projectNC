package tables;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EVENTS")
public class Event {
	@Id
	@Column(name="EVENT_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int event_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DATE_TIME_NEW")
	private Date dateNew;
	
	@Column(name="DATE_TIME_END")
	private Date dateEnd;
	
	@Column(name="DISCOUNT")
	private int discount;
	
	public int getEventId(){
		return this.event_id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Date getDateNew(){
		return this.dateNew;
	}
	
	public Date getDateEnd(){
		return this.dateEnd;
	}
	
	public int getDiscount(){
		return this.discount;
	}
	
	public void setEventId(int id){
		this.event_id = id;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setDescription(String d){
		this.description = d;
	}
	
	public void setDateNew(Date d){
		this.dateNew = d;
	}
	
	public void setDateEnd(Date d){
		this.dateEnd = d;
	}
	
	public void setDiscount(int d){
		this.discount = d;
	}
}
