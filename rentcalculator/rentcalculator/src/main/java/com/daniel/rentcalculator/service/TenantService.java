package com.daniel.rentcalculator.service;

import com.daniel.rentcalculator.exception.UserNotFoundException;
import com.daniel.rentcalculator.model.Tenant;
import com.daniel.rentcalculator.repo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TenantService {
    @Autowired
    private final TenantRepo tenantRepo;

    @Autowired
    public TenantService(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    public Tenant addTenant(Tenant tenant) {
        tenant.setTenantCode(UUID.randomUUID().toString());
        setTenantCost(tenant);
        return tenantRepo.save(tenant);
    }

    public List<Tenant> findAllTenants() {
        return tenantRepo.findAll();
    }

    public Tenant updateTenant(Tenant tenant) {
        setTenantCost(tenant);
        return tenantRepo.save(tenant);
    }

    public Tenant findTenantById(Long id) {
        return tenantRepo.findTenantById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteTenant(Long id) {
        tenantRepo.deleteTenantById(id);
    }

    /**
     * Verify the cost owed for the tenant is correct
     */
    private void setTenantCost(Tenant tenant) {
        tenant.setCostOwed((tenant.getApartmentCost() * (tenant.getApartmentFootage()) / tenant.getTotApartmentFootage()));
    }

}
