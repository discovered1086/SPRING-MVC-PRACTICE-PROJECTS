package com.kingshuk.springprojects.validator;

import com.kingshuk.springprojects.EmployeeServiceImpl;
import com.kingshuk.springprojects.beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private EmployeeServiceImpl employeeService;
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param employeeId the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Employee convert(String employeeId) {
        return employeeService.findEmployee(Integer.parseInt(employeeId));
    }
}
