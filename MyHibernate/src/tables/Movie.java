package tables;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MOVIES")
public class Movie {
	public Movie(){}
	
	public Movie(String n, String des, String sdes, String der, Date d1, Date d2){
		name = n;
		description = des;
		short_description = sdes;
		derector = der;
		year_release = d1;
		lenght = d2;
	}
	
	@Id
	@Column(name="MOVIE_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int movie_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DIRECTOR")
	private String derector;
	
	@Column(name="SHORT_DESCRIPTION")
	private String short_description;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="YEAR_RELEASE")
	private Date year_release;
	
	@Column(name="LENGHT")
	private Date lenght;
	
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
	
	@ManyToMany
	@JoinTable(
			name="MOVIES_EVENTS",
			joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")})
	private List<Event> events;
					
	public int getId(){
		return movie_id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDerector(){
		return derector;
	}
	
	public String getShortDescription(){
		return short_description;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Date getYearRelease(){
		return year_release;
	}
	
	public Date getLenght(){
		return lenght;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public List<Event> getEvents(){
		return events;
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
	
	public void setEvents(List<Event> events){
		this.events = events;
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
	
	public void setLenght(Date t){
		this.lenght = t;
	}
}
