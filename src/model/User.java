/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Eleea
 *
 */

@Entity
public class User {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="email")
	private String email;
	
	@Column(name="howMuch")
	private double howMuch;
	
	@Column(name="forWho")
	private int forWho;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, double howMuch, int forWho) {
		super();
		this.email = email;
		this.howMuch = howMuch;
		this.forWho = forWho;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getHowMuch() {
		return howMuch;
	}
	public void setHowMuch(double howMuch) {
		this.howMuch = howMuch;
	}
	public int getForWho() {
		return forWho;
	}
	public void setForWho(int forWho) {
		this.forWho = forWho;
	}
	
	
}
