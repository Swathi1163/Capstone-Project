package com.capstone.flatbookingdata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.flatbookingdata.modal.Tenant;

@FeignClient(name="TENANT-DATA")
public interface TenantServiceConsumer {

	@GetMapping("/tenantdata/viewtenant/{tenantId}")
	 Tenant getTenantData(@PathVariable("tenantId") int tenantId);
	
}

