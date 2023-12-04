package com.utsem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.Model.DetalleVenta;

public interface detVentaRepository extends JpaRepository<DetalleVenta, Long>{
	 
}
