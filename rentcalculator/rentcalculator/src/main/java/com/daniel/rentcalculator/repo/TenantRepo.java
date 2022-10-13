package com.daniel.rentcalculator.repo;

import com.daniel.rentcalculator.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepo extends JpaRepository<Tenant, Long> {

    void deleteTenantById(Long id);

    Optional<Tenant> findTenantById(Long id);
}
