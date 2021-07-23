package com.hms.interfaces;

import com.hms.entity.InterventionEntity;
import com.hms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface Intervention {
    public List<InterventionEntity> getAllIntervention();
    public List<InterventionEntity> getInterventionByEmployeeid(@PathVariable Long id);
    public InterventionEntity createIntervention(@Valid @RequestBody InterventionEntity intervention);
    public List<InterventionEntity> getInterventionById(@PathVariable Long id);
    public List<InterventionEntity> getInterventionByCommandeId(@PathVariable Long id);
    public List<InterventionEntity> getInterventionByService(@PathVariable String service);
    public Boolean updateIntervnetion(@Valid @RequestBody InterventionEntity InterventionDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteIntervention(@Valid @RequestBody Long interventionId)throws ResourceNotFoundException;
}
