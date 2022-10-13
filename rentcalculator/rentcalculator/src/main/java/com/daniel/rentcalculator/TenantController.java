package com.daniel.rentcalculator;

import com.daniel.rentcalculator.model.Tenant;
import com.daniel.rentcalculator.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tenant>> getAllTenants () {
        List<Tenant> tenants = tenantService.findAllTenants();
        System.out.println(tenants);
        return new ResponseEntity<>(tenants, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tenant> getTenantById (@PathVariable("id") Long id) {
        Tenant tenant = tenantService.findTenantById(id);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
        Tenant newTenant = tenantService.addTenant(tenant);
        return new ResponseEntity<>(newTenant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant tenant) {
        Tenant updateTenant = tenantService.updateTenant(tenant);
        return new ResponseEntity<>(updateTenant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteTenant(@PathVariable("id") Long id) {
        tenantService.deleteTenant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
