package com.utsem.Model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String descripcion;
	@Column(unique = true)
	private String codigo;
	@Column
	private String Nombre;
	@Column
	private Float precio;
	@Column
	private String campodisiplinar;
	@Column
	private String Nivel;
	@Column
	private Float existencias = (float) 1;
	@Column
	private Byte estatus;
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID uuid = UUID.randomUUID(); // generaidentificadorAleatoriamente//

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
