package sara.employee.creator.backend.employees;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private ModelMapper mapper;

	public Employee createPost(CreateEmployeeDTO data) {

		Employee newEmployee = mapper.map(data, Employee.class);
		newEmployee.setCreatedAt(new Date());
		return this.repo.save(newEmployee);

	}

	public List<Employee> getAllItems() {
		return this.repo.findAll();

	}

	public Optional<Employee> findById(Long id) {
		return this.repo.findById(id);

	}

	public Optional<Employee> updateById(@Valid UpdateEmployeeDTO data, Long id) {
		Optional<Employee> maybeEmployee = this.findById(id);
		if (maybeEmployee.isEmpty()) {
			return maybeEmployee;
		}
		Employee foundEmployee = maybeEmployee.get();
		mapper.map(data, foundEmployee);
		Employee updated = this.repo.save(foundEmployee);
		return Optional.of(updated);
	}

	public boolean deletePostById(Long id) {
		Optional<Employee> maybeEmployee = this.repo.findById(id);
		if (maybeEmployee.isEmpty()) {
			return false;
		}
		this.repo.delete(maybeEmployee.get());
		return true;
	}

}
