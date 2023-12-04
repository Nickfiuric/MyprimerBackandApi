package com.utsem.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class VentaDTO {
	private Double total = 0d;
	private LocalDateTime fehcaCreacin;
    private Byte estatus;
    private UUID uuid=UUID.randomUUID(); //generaidentificadorAleatoriamente//
    private List<DetalleVentaDTO> detalles = new ArrayList<>();
    private Boolean Ventarealizada = false;
    
	public Boolean getVentarealizada() {
		return Ventarealizada;
	}
	public void setVentarealizada(Boolean ventarealizada) {
		Ventarealizada = ventarealizada;
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
	public List<DetalleVentaDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleVentaDTO> detalles) {
		this.detalles = detalles;
	}
    
}
