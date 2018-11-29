package com.nexos.backend.api.beans;

import java.io.Serializable;
import java.util.Date;

public class QuotationVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idCotizacion;

	private String codigoCotizacion;

	private Date fechaCotizacion;

	private Date fechaEvento;

	private int horas;

	private int validezOferta;

	public QuotationVO() {
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

}