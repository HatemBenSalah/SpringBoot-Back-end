package com.hms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.hms.entity.InterventionEntity;
import com.hms.interfaces.Intervention;
import com.hms.repositories.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/InterventionController")
public class InterventionController implements Intervention {
    @Autowired
    private InterventionRepository interventionRepository;
    @GetMapping("/getallIntervention")
    public List<InterventionEntity> getAllIntervention() {
        return interventionRepository.findAll();
    }
    @GetMapping("/getInterventionByEmployeeid/{id}")
    public List<InterventionEntity> getInterventionByEmployeeid(@PathVariable Long id) {
        return interventionRepository.findInterventionbyemployeeid(id);
    }
    @PostMapping("/createIntervention")
    public InterventionEntity createIntervention(@Valid @RequestBody InterventionEntity intervention) {
        return interventionRepository.save(intervention);
    }
    @GetMapping("/getIntervention/{id}")
    public List<InterventionEntity> getInterventionById(@PathVariable Long id) {
        return interventionRepository.findbyuser(id);
    }
    @GetMapping("/getInterventionbyCommandeID/{id}")
    public List<InterventionEntity> getInterventionByCommandeId(@PathVariable Long id) {
        return interventionRepository.findbycommande(id);
    }
    @GetMapping("/getInterventionByEmployeeService/{service}")
    public List<InterventionEntity> getInterventionByService(@PathVariable String service) {
        return interventionRepository.findbyEmployeeService(service);
    }
    @PostMapping("/updateIntervention")
    public Boolean updateIntervnetion(@Valid @RequestBody InterventionEntity InterventionDetails) throws ResourceNotFoundException {
        InterventionEntity intervention = interventionRepository.findById(InterventionDetails.getIdIntervention())
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation not found for this id :: "));
        try {
            intervention.setEmail(InterventionDetails.getEmail());
            intervention.setLastName(InterventionDetails.getLastName());
            intervention.setFirstName(InterventionDetails.getFirstName());
            intervention.setPhone(InterventionDetails.getPhone());
            intervention.setAdresse(InterventionDetails.getAdresse());
            intervention.setNameservice(InterventionDetails.getNameservice());
            intervention.setInterventionstate(InterventionDetails.getInterventionstate());
            intervention.setDatedemmande(InterventionDetails.getDatedemmande());
            intervention.setDateintervention(InterventionDetails.getDateintervention());
            intervention.setInterventionstate(InterventionDetails.getInterventionstate());
            intervention.setAcceptationdate(InterventionDetails.getAcceptationdate());
            intervention.setInterventiondescription((InterventionDetails.getInterventiondescription()));
            interventionRepository.save(intervention);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping("/deleteIntervention")
    public Map<String, Boolean> deleteIntervention(@Valid @RequestBody Long interventionId)
            throws ResourceNotFoundException {
        InterventionEntity intervention = interventionRepository.findById(interventionId)
                .orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + interventionId));

        interventionRepository.delete(intervention);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
