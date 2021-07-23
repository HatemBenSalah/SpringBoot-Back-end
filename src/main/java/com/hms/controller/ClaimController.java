package com.hms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.hms.entity.ClaimEntity;
import com.hms.interfaces.Claim;
import com.hms.repositories.ClaimRepository;
import com.hms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/ClaimController")
public class ClaimController implements Claim {
    @Autowired
    private ClaimRepository claimRepository;
    @GetMapping("/getallClaim")
    public List<ClaimEntity> getAllClaim() {
        return claimRepository.findAll();
    }
    @GetMapping("/getClaimByEmployeeid/{id}")
    public List<ClaimEntity> getClaimByEmployeeid(@PathVariable Long id) {

        return claimRepository.findclaimbyemployeeid(id);
    }
    @PostMapping("/createClaim")
    public ClaimEntity createClaim(@Valid @RequestBody ClaimEntity claim) {
        return claimRepository.save(claim);
    }
    @GetMapping("/getClaim/{id}")
    public List<ClaimEntity> getClaimById(@PathVariable Long id) {
        return claimRepository.findbyuser(id);
    }

    @GetMapping("/getClaimByEmployeeService/{service}")
    public List<ClaimEntity> getClaimByService(@PathVariable String service) {
        System.out.println("claim:"+service);

        return claimRepository.findbyEmployeeService(service);

    }
    @PostMapping("/updateClaim")
    public Boolean updateReclamation(@Valid @RequestBody ClaimEntity ReclamationDetails) throws ResourceNotFoundException {
        ClaimEntity reclamation = claimRepository.findById(ReclamationDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation not found for this id :: "));
        try {
            reclamation.setEmail(ReclamationDetails.getEmail());
            reclamation.setLastName(ReclamationDetails.getLastName());
            reclamation.setFirstName(ReclamationDetails.getFirstName());
            reclamation.setPhone(ReclamationDetails.getPhone());
            reclamation.setAdresse(ReclamationDetails.getAdresse());
            reclamation.setNameservice(ReclamationDetails.getNameservice());
            reclamation.setClaimdescription(ReclamationDetails.getClaimdescription());
            reclamation.setState(ReclamationDetails.getState());
            reclamation.setDatedemmande(ReclamationDetails.getDatedemmande());
            reclamation.setEmployee(ReclamationDetails.getEmployee());
            reclamation.setAcceptationdate(ReclamationDetails.getAcceptationdate());
            reclamation.setInterventionstate(ReclamationDetails.getInterventionstate());
            claimRepository.save(reclamation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteClaim")
    public Map<String, Boolean> deleteReclamation(@Valid @RequestBody Integer reclamationID)
            throws ResourceNotFoundException {
        ClaimEntity reclamation = claimRepository.findById(reclamationID)
                .orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + reclamationID));

        claimRepository.delete(reclamation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
