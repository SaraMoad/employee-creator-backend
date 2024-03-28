package sara.employee.creator.backend.employees;

import java.util.Date;

import jakarta.validation.constraints.Pattern;

public class UpdateEmployeeDTO {

		@Pattern(regexp = "^(?=\\S).*$", message = "First Name Cannot be empty")
		private String FirstName;
		
		@Pattern(regexp = "^(?=\\S).*$", message = "Last Name Cannot be empty")
		private String LastName;

		@Pattern(regexp = "^(?=\\S).*$", message = "Role Title Cannot be empty")
		private String roleTitle;
		
		private Date createdAt;
		
		private Date startDate;
		
		private String contract;
		
		private String email;
		
		private Date DOB;
		
		private String LengthOfEmployment;

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
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
		
		
	}