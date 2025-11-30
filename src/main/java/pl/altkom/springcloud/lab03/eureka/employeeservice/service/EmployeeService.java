package pl.altkom.springcloud.lab03.eureka.employeeservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.mapper.RequestMapper;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.mapper.ResponseMapper;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model.CreateEmployeeRequest;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model.Employee;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model.UpdateEmployeeRequest;
import pl.altkom.springcloud.lab03.eureka.employeeservice.repository.EmployeeRepository;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return ResponseMapper.map(employeeRepository.findAll());
    }

    public Employee getEmployee(final Long employeeId) {
        final pl.altkom.springcloud.lab03.eureka.employeeservice.repository.model.Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseMapper.map(employee);
    }

    public Employee createEmployee(final CreateEmployeeRequest request) {
        final pl.altkom.springcloud.lab03.eureka.employeeservice.repository.model.Employee savedEmployee = employeeRepository
                .save(RequestMapper.bind(request));
        return ResponseMapper.map(savedEmployee);
    }

    public Employee modifyEmployee(final Long employeeId, final UpdateEmployeeRequest request) {

        final pl.altkom.springcloud.lab03.eureka.employeeservice.repository.model.Employee sourceEmployee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        final pl.altkom.springcloud.lab03.eureka.employeeservice.repository.model.Employee modifiedEmployee = employeeRepository
                .save(RequestMapper.bind(request, sourceEmployee));
        return ResponseMapper.map(modifiedEmployee);
    }

    public List<Employee> getProjectEmployees(final Long projectId) {
        return ResponseMapper.map(employeeRepository.findByProjectId(projectId));
    }
}
