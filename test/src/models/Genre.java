package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GENRES")
public class Genre {
	public Genre(){}
	
	public Genre(String n){
        this.name = n;
    }
	
	@Id
	@Column(name="GENRE_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int genreId;
	
	@Column(name="NAME")
	private String name;
		
	public int getGenreId(){
		return genreId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setGenreId(int id){
		this.genreId = id;
    }
    
    public void setName(String name){
        this.name = name;
    }   
}
