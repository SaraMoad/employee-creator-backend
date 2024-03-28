package sara.employee.creator.backend.employees;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEmployeeDTO {

		@NotBlank
		private String firstName;
		
		@NotBlank
		private String lastName;

		@NotBlank
		private String RoleTitle;

		@NotNull
		private Date StartDate;
		
		@NotNull
		private int contract;
		
		@NotNull
		private Date startDate;
		
		@NotNull
		private String email;
		
		@NotNull
		private Date DOB;
		
		@NotNull
		private String LengthOfEmployment;

}


