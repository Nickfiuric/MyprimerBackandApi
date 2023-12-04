package com.utsem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.Model.venta;

public interface VentaRepository extends JpaRepository<venta, Long> {
	
}
