package com.setupservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alumno_presentacion")
public class AlumnoPresentacion implements AbstractEntity, Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alu_pres_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_alumno"),name="alu_id",nullable=false)
	//@JsonIgnoreProperties({"curso","observacion"})
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_presentacion"),name="pres_id",nullable=false)
	//@JsonIgnoreProperties({"facultad","observacion"})
	private Presentacion presentacion;
	public AlumnoPresentacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Presentacion getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

}
