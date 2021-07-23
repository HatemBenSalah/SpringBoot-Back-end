package com.hms.interfaces;

import com.hms.entity.EmployeeEntity;
import com.hms.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface Employee {
    public List<EmployeeEntity> getAllEmployees();
    public Boolean  getEmployeeIfexitByEmail(@PathVariable String email);
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Long employeeId)throws ResourceNotFoundException;
    public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employee);
    public Boolean updateEmployee(@Valid @RequestBody EmployeeEntity EmployeeDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteEmployee(@Valid @RequestBody Long employeeID) throws ResourceNotFoundException;
}
