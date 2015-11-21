package logic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Movies")
public class Movie {
	private int movie_id;
	private String name;
	private String derector;
	private String short_description;
	private String description;
	private Date year_release;
	private Time lenght;
	
	public Movie(){
		movie_id = 0;
		name = null;
		description = null;
		short_description = null;
		derector = null;
		year_release = null;
		lenght = null;
	}
	
	public Movie(Movie m){
		movie_id = m.getId();
		name = m.getName();
		derector = m.getDerector();
		short_description = m.getShortDescription();
		description = m.getDescription();
		year_release = m.getYearRelease();
		lenght = m.getLenght();
	}
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="movie_id")
	public int getId(){
		return movie_id;
	}
	
	@Column(name="name")
	public String getName(){
		return name;
	}
	
	@Column(name="derector")
	public String getDerector(){
		return derector;
	}
	
	@Column(name="short_description")
	public String getShortDescription(){
		return short_description;
	}
	
	@Column(name="description")
	public String getDescription(){
		return description;
	}
	
	@Column(name="year_release")
	public Date getYearRelease(){
		return year_release;
	}
	
	@Column(name="lenght")
	public Time getLenght(){
		return lenght;
	}
	
	public void setId(int i){
		this.movie_id = i;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setDerector(String d){
		this.derector = d;
	}
	
	public void setShortDescription(String sd){
		this.short_description = sd;
	}
	
	public void setDescription(String d){
		this.description = d;
	}
	
	public void setYearRelease(Date d){
		this.year_release = d;
	}
	
	public void setLenght(Time t){
		this.lenght = t;
	}
}
