package com.hms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.hms.entity.EmployeeEntity;
import com.hms.interfaces.Employee;
import com.hms.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/EmployeeController")
public class EmployeeController implements Employee {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder encoder;
    @GetMapping("/getEmployee")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/getEmployeeByEmail/{email}")
    public Boolean  getEmployeeIfexitByEmail(@PathVariable String email) {
        return employeeRepository.existsByEmail(email);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Long employeeId)throws ResourceNotFoundException {
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
            employee.setEmail(EmployeeDetails.getEmail());
            employee.setCin(EmployeeDetails.getCin());
            employee.setFirstName(EmployeeDetails.getFirstName());
            employee.setLastName(EmployeeDetails.getLastName());
            employee.setPhone(EmployeeDetails.getPhone());
            employee.setEmployeservice(EmployeeDetails.getEmployeservice());
            employee.setPassword(encoder.encode(EmployeeDetails.getPassword()));
            employee.setAdresse(EmployeeDetails.getAdresse());


            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping("/deleteEmployee")
    public Map<String, Boolean> deleteEmployee(@Valid @RequestBody Long employeeID)
            throws ResourceNotFoundException {
        EmployeeEntity employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeID));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
