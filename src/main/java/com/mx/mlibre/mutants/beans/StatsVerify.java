package com.mx.mlibre.mutants.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="estatus")
public class StatsVerify implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cadena_peticion")
	private String cadenaPeticion;
	@Column(name="bnd_resultado", length = 1)
	private Integer bndResultado;
	@Column(name="fecha_cambio")
	@Temporal(TemporalType.DATE)
	private Date fechaCambio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCadenaPeticion() {
		return cadenaPeticion;
	}
	public void setCadenaPeticion(String cadenaPeticion) {
		this.cadenaPeticion = cadenaPeticion;
	}
	public Integer getBndResultado() {
		return bndResultado;
	}
	public void setBndResultado(Integer bndResultado) {
		this.bndResultado = bndResultado;
	}
	public Date getFechaCambio() {
		return fechaCambio;
	}
	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}
	
}
