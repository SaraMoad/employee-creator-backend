package sara.employee.creator.backend.employees;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	
@Table(name = "todo_items")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Date createdAt;
	
	@Column
	private Date startDate;
	
	@Column
	private String contract;
	
	@Column
	private String roleTitle;
	
	@Column
	private String email;
	
	@Column
	private Date DOB;
	
	@Column 
	private String LengthOfEmployment;
	
	public Employee() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getLengthOfEmployment() {
		return LengthOfEmployment;
	}

	public void setLengthOfEmployment(String lengthOfEmployment) {
		LengthOfEmployment = lengthOfEmployment;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", createdAt=" + createdAt
				+ ", startDate=" + startDate + ", contract=" + contract + ", roleTitle=" + roleTitle + ", email="
				+ email + ", DOB=" + DOB + ", LengthOfEmployment=" + LengthOfEmployment + "]";
	}
}

