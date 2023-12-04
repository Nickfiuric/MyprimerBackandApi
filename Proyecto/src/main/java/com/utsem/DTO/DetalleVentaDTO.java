package com.utsem.DTO;

import java.util.UUID;

public class DetalleVentaDTO {
	private float precio;
	private float cantidad;
	private double subtotal;
	private String Nivel;
    private Byte estatus = 1;
    private UUID uuid=UUID.randomUUID(); //generaidentificadorAleatoriamente//
    private ProductoDTO  productoDTO = new ProductoDTO() ;
    private Boolean detalleGuardar = false;
    
	public String getNivel() {
		return Nivel;
	}
	public void setNivel(String nivel) {
		Nivel = nivel;
	}
	public Boolean getDetalleGuardar() {
		return detalleGuardar;
	}
	public void setDetalleGuardar(Boolean detalleGuardar) {
		this.detalleGuardar = detalleGuardar;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}
    
}
