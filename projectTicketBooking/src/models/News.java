package models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NEWS")
public class News {
	public News(){}
	
	public News(Movie m,String n, String de, Date d){
		this.movieNews = m;
		this.name = n;
		this.description = de;
		this.date = d;
	}
	
	@Id
	@Column(name="NEWS_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int newsId;

	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private Movie movieNews;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DATE_TIME")
	private Date date;
	
	public int getNewsId(){
		return this.newsId;
	}
	
	public Movie getMovie_id(){
		return this.movieNews;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Date getDate(){
		return this.date;
	}

	public void setNewsId(int id){
		this.newsId = id;
	}

	public void setMovie_id(Movie movie){
		this.movieNews = movie;
	}

	public void setName(String n){
		this.name = n;
	}

	public void setDescription(String d){
		this.description = d;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
}
