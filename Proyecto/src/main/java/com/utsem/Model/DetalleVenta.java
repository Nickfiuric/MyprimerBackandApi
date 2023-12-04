package com.utsem.Model;
//Creamos una base de datos*//
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column
	private float precio;
	@Column
	private float cantidad;
	@Column
	private double subtotal;
	@Column
    private Byte estatus;
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid=UUID.randomUUID(); //generaidentificadorAleatoriamente//
	
	//LLave_foranea//
	
	@ManyToOne
	private venta venta;
	@ManyToOne
	private Producto producto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public venta getVenta() {
		return venta;
	}
	public void setVenta(venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
