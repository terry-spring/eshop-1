package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "{customer.companyname}")
	@Size(min = 5,message = "{companyname.size}")
	@Column(name= "companyName")
	private String companyName;

	@NotBlank(message = "{customer.contacname}")
	@Size(min = 5,message = "{customer.contacname.size}")
	@Column(name = "contacName")
	private String contacName;
	
	private String city;
	
	private String state;
	
	@Pattern(regexp = "[0-9]{5}",message = "{customer.postalcode.pattern}")
	@Column(name = "postalCode")
	private String postalCode;
	
	@Pattern(regexp = "[0-9]{10}",message = "{customer.phonecode.pattern}")
	@Column(name = "phoneNumber")
	private String phoneNumber;
    
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContacName() {
		return contacName;
	}

	public void setContacName(String contacName) {
		this.contacName = contacName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
