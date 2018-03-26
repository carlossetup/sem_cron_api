package com.setupservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


@Entity
public class Presentacion implements AbstractEntity, Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pres_id")
	private Integer id;
	@Column(length=255,nullable=false)
	private String descripcion;
	
	@Column(name="fecha_presentacion")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate fechaPresentacion;
	
	@Column(name="hora_inicio")
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalTime horaInicio;
	
	@Column(name="hora_fin")
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalTime horaFin;
	
	@Column(columnDefinition="boolean default false") 
	private Boolean concluido;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(foreignKey=@ForeignKey(name="fk_carrera"),name="carr_id",nullable=false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "id")
	//@JsonIgnoreProperties({"filial", "fechaInscripcion","observacion"})
	//@JsonIgnore
	private Carrera carrera;


	public Presentacion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFechaPresentacion() {
		return fechaPresentacion;
	}


	public void setFechaPresentacion(LocalDate fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	

	public Boolean getConcluido() {
		return concluido;
	}


	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}


	public Carrera getCarrera() {
		return carrera;
	}


	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
