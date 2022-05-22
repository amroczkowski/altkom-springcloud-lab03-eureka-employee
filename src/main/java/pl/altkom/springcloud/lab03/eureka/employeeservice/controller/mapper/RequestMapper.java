package pl.altkom.springcloud.lab03.eureka.employeeservice.controller.mapper;

import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model.CreateEmployeeRequest;
import pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model.UpdateEmployeeRequest;
import pl.altkom.springcloud.lab03.eureka.employeeservice.repository.model.Employee;

public class RequestMapper {

    public static Employee bind(final CreateEmployeeRequest request) {
        final Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setCity(request.getCity());
        employee.setProjectId(request.getProjectId());
        return employee;
    }

    public static Employee bind(final UpdateEmployeeRequest request, final Employee destination) {
        destination.setFirstName(request.getFirstName());
        destination.setLastName(request.getLastName());
        destination.setCity(request.getCity());
        destination.setProjectId(request.getProjectId());
        return destination;
    }
}
