package main.model;


import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


//**set customer table
 
 
@Entity
@Table(name = "customer")
public class Customer { 
	
	public enum CITY {
		基隆市,台北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,台中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,台南市,高雄市,
		屏東縣,台東縣,花蓮縣,宜蘭縣,澎湖縣,金門縣,連江縣
	}
    
	public enum POSTAL_CODE {
		台北市_中山區104,台北市_信義區110,台北市_內湖區114,新北市_板橋區220,新北市_中和區235
	}
	
	public enum STATE {
		北部,中部,南部,東部,離島
	}
	
	/**建構Customer
	 * 
	 */
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
	
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Pattern(regexp = "^09\\d{8}",message = "{請輸入10碼行動電話號碼}")
	@Column(name = "phone_number")
	private String phoneNumber;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_userId")
	private User user;
	
	private long userId;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_TIME",length = 7)
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_TIME",length = 7)
	private Date updateTime;

    
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
	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
