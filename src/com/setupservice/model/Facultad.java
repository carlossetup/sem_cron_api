package com.setupservice.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facultad
 *
 */
@Entity

public class Facultad implements Serializable, AbstractEntity {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="facu_id")
	private Integer id;
	private String descripcion;
	private String sigla;
	private static final long serialVersionUID = 1L;

	public Facultad() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
   
}
