package sara.employee.creator.backend.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sara.employee.creator.backend.exceptions.NotFoundException;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService EmployeeService;

	@PostMapping
	public ResponseEntity<Employee> createPost(@Valid @RequestBody CreateEmployeeDTO data) {
		Employee createdEmployee = this.EmployeeService.createPost(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllItems() {
		List<Employee> allEmployees = this.EmployeeService.getAllItems();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getItemById(@PathVariable Long id) throws NotFoundException {
		Optional<Employee> maybeEmployee = this.EmployeeService.findById(id);
		Employee foundEmployee = maybeEmployee.orElseThrow(() -> new NotFoundException(Employee.class, id));
		return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updatePostById(@Valid @RequestBody UpdateEmployeeDTO data, @PathVariable Long id)
			throws NotFoundException {
		Optional<Employee> maybeUpdatedEmployee = this.EmployeeService.updateById(data, id);
		Employee updatedEmployee = maybeUpdatedEmployee.orElseThrow(() -> new NotFoundException(Employee.class, id));
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deletePostById(@PathVariable Long id) throws NotFoundException {
		boolean deleted = this.EmployeeService.deletePostById(id);
		if (!deleted) {
			throw new NotFoundException(Employee.class, id);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}
