package com.utsem.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column
	private Double total;
	@CreationTimestamp
	@Column
	private LocalDateTime fehcaCreacin;
	@Column
    private Byte estatus = 1;
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid =UUID.randomUUID(); //generaidentificadorAleatoriamente//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public LocalDateTime getFehcaCreacin() {
		return fehcaCreacin;
	}
	public void setFehcaCreacin(LocalDateTime fehcaCreacin) {
		this.fehcaCreacin = fehcaCreacin;
	}
	public Byte getEstatus() {
		return estatus;
	}
	public void setEstatus(Byte estatus) {
		this.estatus = estatus;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
}
