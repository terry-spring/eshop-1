package main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	private String login;
	
	@Column
	private String password;
	
	@Transient
	private String confirmedPasswordString;
	
	private boolean enabled;
	
//	@OneToOne(mappedBy = "user")
//	private Customer customer;
	
	
//	@ManyToMany
//	@JoinTable(name = "customer2user",
//			   joinColumns = @JoinColumn(name = "user_userId"),
//			   inverseJoinColumns = @JoinColumn(name = "customer_customerId"))
			   
//	private List<Customer> customers;

	




	public String getConfirmedPasswordString() {
		return confirmedPasswordString;
	}



	public void setConfirmedPasswordString(String confirmedPasswordString) {
		this.confirmedPasswordString = confirmedPasswordString;
	}



//	public Customer getCustomer() {
//		return customer;
//	}
//
//
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}



//	public List<Customer> getCustomers() {
//		return customers;
//	}
//
//
//
//	public void setCustomers(List<Customer> customers) {
//		this.customers = customers;
//	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
		
}
