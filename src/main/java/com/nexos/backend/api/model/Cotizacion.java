package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the cotizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Cotizacion.findAll", query="SELECT c FROM Cotizacion c")
public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cotizacion")
	private Long idCotizacion;

	@Column(name="codigo_cotizacion")
	private String codigoCotizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cotizacion")
	private Date fechaCotizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	private int horas;

	@Column(name="validez_oferta")
	private int validezOferta;

	

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Cotizacion() {
	}

	public Long getIdCotizacion() {
		return this.idCotizacion;
	}

	public void setIdCotizacion(Long idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public String getCodigoCotizacion() {
		return this.codigoCotizacion;
	}

	public void setCodigoCotizacion(String codigoCotizacion) {
		this.codigoCotizacion = codigoCotizacion;
	}

	public Date getFechaCotizacion() {
		return this.fechaCotizacion;
	}

	public void setFechaCotizacion(Date fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public int getHoras() {
		return this.horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getValidezOferta() {
		return this.validezOferta;
	}

	public void setValidezOferta(int validezOferta) {
		this.validezOferta = validezOferta;
	}

	

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}