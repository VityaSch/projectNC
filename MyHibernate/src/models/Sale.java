package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SALES")
public class Sale {
	public Sale(){}
	
	public Sale(Tickets t, Date d, int p){
		this.ticket = t;
		this.date = d;
		this.price = p;
	}
	
	@Id
	@Column(name="SALE_ID")
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private int sale_id;
	
	@OneToOne
	@JoinColumn(name="TICKET_ID")
	private Tickets ticket;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="PRICE")
	private int price;
	
	public int getSaleId(){
		return this.sale_id;
	}
	
	public Tickets getTicket(){
		return this.ticket;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public int getPrice(){
		return this.price;
	}

	public void setSaleId(int id){
		this.sale_id =id;
	}
	
	public void setTicket(Tickets t){
		this.ticket = t;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
	
	public void setPrice(int p){
		this.price = p;
	}
}
