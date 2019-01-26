package com.kingshuk.springprojects.validator;

import com.kingshuk.springprojects.beans.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("Inside the validate method");
        Employee employee = (Employee) o;

        //ValidationUtils.rejectIfEmpty(errors,"employeeId","employee.employeeId","Employee ID needs to be specified");

        if (employee.getEmployeeId()==null || employee.getEmployeeId()==0) {
            errors.rejectValue("employeeId", "employee.employeeId",
                    "Employee ID needs to be specified");
        }
    }
}
