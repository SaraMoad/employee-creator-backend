package sara.employee.creator.backend.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sara.employee.creator.backend.employees.CreateEmployeeDTO;
import sara.employee.creator.backend.employees.Employee;
import sara.employee.creator.backend.employees.UpdateEmployeeDTO;


@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());
		mapper.getConfiguration().setSkipNullEnabled(true);


		mapper.typeMap(CreateEmployeeDTO.class, Employee.class).addMappings(
			m -> m.using(new LowerCaseConverter()));

		mapper.typeMap(UpdateEmployeeDTO.class, Employee.class).addMappings(
				m -> m.using(new LowerCaseConverter()));
		return mapper;
	}

	private class StringTrimConverter implements Converter<String, String> {

		@Override
		public String convert(MappingContext<String, String> context) {
			if (context.getSource() == null) {
				return null;
			}
			return context.getSource().trim();
		}
	}

	private class LowerCaseConverter implements Converter<String, String> {

		@Override
		public String convert(MappingContext<String, String> context) {
			if (context.getSource() == null) {
				return null;
			}
			return context.getSource().toLowerCase();
		}
	}

}