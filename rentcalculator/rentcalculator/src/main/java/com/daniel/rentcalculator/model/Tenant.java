package com.daniel.rentcalculator.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tenant implements Serializable {

    //==================================================== Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private int apartmentCost;
    private int apartmentFootage;
    private int totApartmentFootage;
    private int costOwed;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String tenantCode;

    //==================================================== Constructors
    public Tenant() {

    }

    public Tenant(long id, String name, int apartmentCost, int apartmentFootage, int totApartmentFootage, int costOwed, String imageUrl, String tenantCode) {
        this.id = id;
        this.name = name;
        this.apartmentCost = apartmentCost;
        this.apartmentFootage = apartmentFootage;
        this.totApartmentFootage = totApartmentFootage;
        this.costOwed = costOwed;
        this.imageUrl = imageUrl;
        this.tenantCode = tenantCode;
    }

    //==================================================== Methods
    @java.lang.Override
    public java.lang.String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apartmentCost=" + apartmentCost +
                ", apartmentFootage=" + apartmentFootage +
                ", totApartmentFootage=" + totApartmentFootage +
                ", costOwed=" + costOwed +
                ", imageUrl='" + imageUrl + '\'' +
                ", tenantCode='" + tenantCode + '\'' +
                '}';
    }

//    public int getCost() {
//        if (totApartmentFootage == 0) throw new RuntimeException("Input a number greater than 0 for total apartment footage");
//        return apartmentCost * (apartmentFootage / totApartmentFootage);
//    }

    //==================================================== Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApartmentCost() {
        return apartmentCost;
    }

    public void setApartmentCost(int apartmentCost) {
        this.apartmentCost = apartmentCost;
    }

    public int getApartmentFootage() {
        return apartmentFootage;
    }

    public void setApartmentFootage(int apartmentFootage) {
        this.apartmentFootage = apartmentFootage;
    }

    public int getTotApartmentFootage() {
        return totApartmentFootage;
    }

    public void setTotApartmentFootage(int totApartmentFootage) {
        this.totApartmentFootage = totApartmentFootage;
    }

    public int getCostOwed() {
        return costOwed;
    }

    public void setCostOwed(int costOwed) {
        this.costOwed = costOwed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}
