package com.demo.parser.model;

import com.demo.parser.interfaces.BaseModel;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.*;
import java.util.stream.Collectors;

public class Employees implements BaseModel {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<EmployeePro> employee;

    public List<EmployeePro> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeePro> employee) {
        this.employee = employee;
    }

    @Override
    public void appendObject(BaseModel object) {
        Employees employees = (Employees) object;
        employee.addAll(employees.getEmployee());
    }

    @Override
    public void deleteObject(BaseModel object) {

        Employees employees = (Employees) object;
        List<EmployeePro> deleteEmployee = employees.getEmployee();

        List<String> deleteEmployeeNames = new ArrayList<>();
        for (EmployeePro employee : deleteEmployee){
            deleteEmployeeNames.add(employee.getName());
        }

        Iterator<EmployeePro> iterator = this.employee.iterator();
        while(iterator.hasNext()) {
            EmployeePro next = iterator.next();
            if(deleteEmployeeNames.contains(next.getName())) {
                iterator.remove();
            }
        }
    }

    @Override
    public void modifyObject(BaseModel object) {
        Employees updatedEmployees = (Employees) object;
        Map<String, EmployeePro> updatedEmployeeMap = updatedEmployees.getEmployee().stream()
                .collect(Collectors.toMap(EmployeePro::getName, item -> item));

        Map<String, EmployeePro> existingEmployeeMap = employee.stream()
                .collect(Collectors.toMap(EmployeePro::getName, item -> item));

        for (String existingEmployee : existingEmployeeMap.keySet()){
            if (updatedEmployeeMap.containsKey(existingEmployee)){
                existingEmployeeMap.put(existingEmployee, updatedEmployeeMap.get(existingEmployee));
            }
        }
        employee = new ArrayList<>(existingEmployeeMap.values());
    }

}
