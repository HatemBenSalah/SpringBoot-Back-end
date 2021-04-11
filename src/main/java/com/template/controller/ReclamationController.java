package com.template.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.template.entity.ReclamationEntity;
import com.template.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.template.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/ReclamationController")
public class ReclamationController {
    @Autowired
    private ReclamationRepository reclamationRepository;

    @GetMapping("/getReclamation")
    public List<ReclamationEntity> getAllReclamation() {
        return reclamationRepository.findAll();
    }




    @PostMapping("/createReclamation")
    public ReclamationEntity createReclamation(@Valid @RequestBody ReclamationEntity reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @PostMapping("/updateReclamation")
    public Boolean updateReclamation(@Valid @RequestBody ReclamationEntity ReclamationDetails) throws ResourceNotFoundException {
        ReclamationEntity reclamation = reclamationRepository.findById(ReclamationDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation not found for this id :: "));
        try {
            reclamation.setEmail(ReclamationDetails.getEmail());
            reclamation.setLastName(ReclamationDetails.getLastName());
            reclamation.setFirstName(ReclamationDetails.getFirstName());
            reclamation.setPhone(ReclamationDetails.getPhone());
            reclamation.setAdresse(ReclamationDetails.getAdresse());
            reclamation.setNameservice(ReclamationDetails.getNameservice());
            reclamation.setReclamationdescription(ReclamationDetails.getReclamationdescription());
            reclamationRepository.save(reclamation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteReclamation")
    public Map<String, Boolean> deleteReclamation(@Valid @RequestBody Integer reclamationID)
            throws ResourceNotFoundException {
        ReclamationEntity reclamation = reclamationRepository.findById(reclamationID)
                .orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + reclamationID));

        reclamationRepository.delete(reclamation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
