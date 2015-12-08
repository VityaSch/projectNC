package models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MOVIES")
public class Movie {
	public Movie(){}
	
	public Movie(String n, String des, String sdes, String der, Date d1, Date d2){
		name = n;
		description = des;
		shortDescription = sdes;
		director = der;
		yearRelease = d1;
		length = d2;
	}
	
	@Id
	@Column(name="MOVIE_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int movieId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DIRECTOR")
	private String director;
	
	@Column(name="SHORT_DESCRIPTION")
	private String shortDescription;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="YEAR_RELEASE")
	private Date yearRelease;
	
	@Column(name="LENGTH")
	private Date length;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movieNews")
	private List<News> news;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movieSession")
	private List<Sesion> session;
	
	@ManyToMany
	@JoinTable(
			name="MOVIES_GENRES",
			joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")})
	private List<Genre> genres;
					
	public int getId(){
		return movieId;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDirector(){
		return director;
	}
	
	public String getShortDescription(){
		return shortDescription;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Date getYearRelease(){
		return yearRelease;
	}
	
	public Date getLenght(){
		return length;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}

	
	public List<News> getNews(){
		return this.news;
	}
	
	public void setNews(List<News> news){
		this.news = news;
	}
	
	public List<Sesion> getSession(){
		return this.session;
	}
	
	public void setSession(List<Sesion> ses){
		this.session = ses;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres; 
	}

	
	public void setId(int id){
		this.movieId = id;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setDirector(String d){
		this.director = d;
	}
	
	public void setShortDescription(String sd){
		this.shortDescription = sd;
	}
	
	public void setDescription(String d){
		this.description = d;
	}
	
	public void setYearRelease(Date d){
		this.yearRelease = d;
	}
	
	public void setLenght(Date t){
		this.length = t;
	}
}
