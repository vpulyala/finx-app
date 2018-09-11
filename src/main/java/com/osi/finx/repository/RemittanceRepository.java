package com.osi.finx.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.osi.finx.model.QxmaFtRemittance;

public interface RemittanceRepository extends PagingAndSortingRepository<QxmaFtRemittance, Long> {
	
}
