package com.hms.interfaces;

import com.hms.entity.ClaimEntity;
import com.hms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface Claim {
    public List<ClaimEntity> getAllClaim();
    public List<ClaimEntity> getClaimByEmployeeid(@PathVariable Long id);
    public ClaimEntity createClaim(@Valid @RequestBody ClaimEntity claim);
    public List<ClaimEntity> getClaimById(@PathVariable Long id);
    public List<ClaimEntity> getClaimByService(@PathVariable String service);
    public Boolean updateReclamation(@Valid @RequestBody ClaimEntity ReclamationDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteReclamation(@Valid @RequestBody Integer reclamationID)throws ResourceNotFoundException;
}
