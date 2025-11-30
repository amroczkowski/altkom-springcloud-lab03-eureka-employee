package pl.altkom.springcloud.lab03.eureka.employeeservice.controller.model;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class CreateEmployeeRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    private Long projectId;
}
