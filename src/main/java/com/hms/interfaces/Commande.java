package com.hms.interfaces;

import com.hms.entity.CommandeEntity;
import com.hms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface Commande {
    public List<CommandeEntity> getCommandByUserId(@PathVariable Long id);
    public List<CommandeEntity> getAllCommand();
    public List<CommandeEntity> getCommandByEmployeeService(@PathVariable String service);
    public List<CommandeEntity> getCommandByEmployeeid(@PathVariable Long id);
    public CommandeEntity createCommande(@Valid @RequestBody CommandeEntity commande);
    public Boolean updateCommande(@Valid @RequestBody CommandeEntity CommandeDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteCommande(@Valid @RequestBody Long commandeID) throws ResourceNotFoundException;
}
