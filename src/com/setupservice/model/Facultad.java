package com.setupservice.model;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_universidad"),name="uni_id",nullable=false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties({"universidad"})
	private Universidad universidad;
	
	
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
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	
	
   
}
