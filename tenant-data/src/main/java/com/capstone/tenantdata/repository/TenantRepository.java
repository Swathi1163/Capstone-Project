package com.capstone.tenantdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.tenantdata.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    
}