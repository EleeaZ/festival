/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Eleea
 *
 */

@Entity
public class Artist {
	
	@Column(name="id")
	@Id
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="price_currency")
	private String currency;
	
	@Column(name="picture")
	private String picture;
	
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artist(String name, double price, String currency, String picture) {
		super();
		this.name = name;
		this.price = price;
		this.currency = currency;
		this.picture = picture;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "Artist [name=" + name + ", price=" + price + ", picture=" + picture + "]";
	}
	
	

}
