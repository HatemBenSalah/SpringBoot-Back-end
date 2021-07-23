package com.hms.repositories;

import com.hms.entity.ClaimEntity;
import com.hms.entity.InterventionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterventionRepository extends JpaRepository<InterventionEntity, Long> {
    @Query(
            value = "select  * from intervention  where user_id=?1",
            nativeQuery = true)
    List<InterventionEntity> findbyuser(Long i);
    @Query(
            value = "select  * from intervention  where commande_id=?1",
            nativeQuery = true)
    List<InterventionEntity> findbycommande(Long i);


    @Query(
            value = "select  * from intervention  where nameservice=?1",
            nativeQuery = true)
    List<InterventionEntity> findbyEmployeeService(String servicename); @Query(
            value = "select  * from intervention  where employee_id=?1",
            nativeQuery = true)
    List<InterventionEntity> findInterventionbyemployeeid(Long id);

}
