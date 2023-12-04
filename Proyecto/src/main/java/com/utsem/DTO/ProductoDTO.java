package com.utsem.DTO;

import java.util.UUID;



public class ProductoDTO {
	
    private String descripcion;
    private String codigo;
    private Float precio;
    private String Nombre;
    private String Nivel;
    private String campodisiplinar;
    private Float existencias;
    private Byte estatus;
    private UUID uuid=UUID.randomUUID(); //generaidentificadorAleatoriamente//
    
	
	public String getCampodisiplinar() {
		return campodisiplinar;
	}
	public void setCampodisiplinar(String campodisiplinar) {
		this.campodisiplinar = campodisiplinar;
	}
	public String getNivel() {
		return Nivel;
	}
	public void setNivel(String nivel) {
		Nivel = nivel;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Float getExistencias() {
		return existencias;
	}
	public void setExistencias(Float existencias) {
		this.existencias = existencias;
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
