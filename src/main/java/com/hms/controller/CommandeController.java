package com.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.hms.entity.CommandeEntity;
import com.hms.entity.EmployeeEntity;
import com.hms.entity.UserEntity;
import com.hms.interfaces.Commande;
import com.hms.repositories.CommandeRepository;
import com.hms.repositories.EmployeeRepository;
import com.hms.repositories.UserRepository;
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
@RequestMapping("/CommandeController")
public class CommandeController implements Commande {

    @Autowired
    private CommandeRepository commandeRepository;
    @GetMapping("/getCommande/{id}")
    public List<CommandeEntity> getCommandByUserId(@PathVariable Long id) {
        return commandeRepository.findbyuser(id);
    }
    @GetMapping("/getAllCommande")
    public List<CommandeEntity> getAllCommand() { return commandeRepository.findAll();
    }
    @GetMapping("/getCommandebyservice/{service}")
    public List<CommandeEntity> getCommandByEmployeeService(@PathVariable String service) {
        return commandeRepository.findbyemployeeService(service);
    }
    @GetMapping("/getCommandebyemployee/{id}")
    public List<CommandeEntity> getCommandByEmployeeid(@PathVariable Long id) {
        return commandeRepository.findcommandbyemployeeid(id);
    }
    @PostMapping("/createCommande")
    public CommandeEntity createCommande(@Valid @RequestBody CommandeEntity commande) {
        return commandeRepository.save(commande);
    }
    @PostMapping("/updateCommande")
    public Boolean updateCommande(@Valid @RequestBody CommandeEntity CommandeDetails) throws ResourceNotFoundException {
        CommandeEntity commande = commandeRepository.findById(CommandeDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: "));
        try {
            commande.setEmail(CommandeDetails.getEmail());
            commande.setLastName(CommandeDetails.getLastName());
            commande.setFirstName(CommandeDetails.getFirstName());
            commande.setPhone(CommandeDetails.getPhone());
            commande.setAdresse(CommandeDetails.getAdresse());
            commande.setNameservice(CommandeDetails.getNameservice());
            commande.setPannedescription(CommandeDetails.getPannedescription());
            commande.setState(CommandeDetails.getState());
            commande.setDatedemmande(CommandeDetails.getDatedemmande());
            commande.setEmployee(CommandeDetails.getEmployee());
            commande.setAcceptationdate(CommandeDetails.getAcceptationdate());
            commande.setInterventionstate(CommandeDetails.getInterventionstate());
            commandeRepository.save(commande);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteCommande")
    public Map<String, Boolean> deleteCommande(@Valid @RequestBody Long commandeID)
            throws ResourceNotFoundException {
        CommandeEntity commande = commandeRepository.findById(commandeID)
                .orElseThrow(() -> new ResourceNotFoundException("commande not found for this id :: " + commandeID));
        commandeRepository.delete(commande);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
