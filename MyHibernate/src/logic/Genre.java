package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GENRES")
public class Genre {
	private int genre_id;
	private String name;
	
	public Genre(){
		name = null;
		genre_id = 0;
	}
	
	public Genre(Genre g){
        name = g.getName();
        genre_id = g.getGenreId();
    }   
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="GENRE_ID")
	public int getGenreId(){
		return genre_id;
	}
	
	@Column(name="NAME")
	public String getName(){
		return name;
	}
	
	public void setGenreId(int i){
		genre_id = i;     
    }
    
    public void setName(String s){
        name = s;
    }   
}
