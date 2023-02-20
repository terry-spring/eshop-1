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
	@Column(name = "customer_id")
	private long customerId;
	
	@NotBlank(message = "{請輸入公司名稱}")
	@Column(name= "company_name")
	private String companyName;

	@NotBlank(message = "{請輸入聯絡人名稱}")
	@Column(name = "contac_name")
	private String contacName;
	
	private String city;
	
	private String state;
	
	@Pattern(regexp = "[0-9]{5}",message = "{請輸入5碼郵遞區號")
	@Column(name = "postal_code")
	private String postalCode;
	
	@Pattern(regexp = "[0-9]{10}",message = "{請輸入10碼行動電話號碼}")
	@Column(name = "phone_number")
	private String phoneNumber;
    
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
