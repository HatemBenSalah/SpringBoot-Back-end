package com.hms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.hms.entity.EmployeeEntity;
import com.hms.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/EmployeeController")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/getEmployee")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Integer employeeId)
            throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/createEmployee")
    public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }
    @PostMapping("/updateEmployee")
    public Boolean updateEmployee(@Valid @RequestBody EmployeeEntity EmployeeDetails) throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findById(EmployeeDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: "));
        try {
            employee.setEmployeemail(EmployeeDetails.getEmployeemail());
            employee.setEmployecin(EmployeeDetails.getEmployecin());
            employee.setEmployeName(EmployeeDetails.getEmployeName());
            employee.setEmployeLastname(EmployeeDetails.getEmployeLastname());
            employee.setEmployephone(EmployeeDetails.getEmployephone());
            employee.setEmployeservice(EmployeeDetails.getEmployeservice());
            employee.setEmployecode(EmployeeDetails.getEmployecode());

            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping("/deleteEmployee")
    public Map<String, Boolean> deleteEmployee(@Valid @RequestBody Integer employeeID)
            throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeID));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}