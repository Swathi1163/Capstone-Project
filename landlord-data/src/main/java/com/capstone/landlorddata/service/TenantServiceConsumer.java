package com.capstone.landlorddata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.landlorddata.model.Tenant;

@FeignClient(name = "TENANT-DATA")
public interface TenantServiceConsumer {
	
	@GetMapping("/tenantdata/viewtenant/{tenantId}")
    Tenant getTenantDetails(@PathVariable("tenantId") int tenantId);

}