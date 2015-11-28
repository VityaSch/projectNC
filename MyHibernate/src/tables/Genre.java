package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	private int genre_id;
	
	@Column(name="NAME")
	private String name;
		
	public int getGenreId(){
		return genre_id;
	}
	
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
