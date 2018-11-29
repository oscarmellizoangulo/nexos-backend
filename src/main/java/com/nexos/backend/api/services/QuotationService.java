package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.beans.QuotationCreateResponseVO;
import com.nexos.backend.api.beans.QuotationVO;
import com.nexos.backend.api.model.Cotizacion;
import com.nexos.backend.api.repository.CotizacionRepository;

@Service
public class QuotationService {
	
	@Autowired
	private CotizacionRepository cotizacionRepository;

	public List<QuotationVO> findAll() {
		Iterable<Cotizacion> quotations = cotizacionRepository.findAll();
		List<QuotationVO> quotationsVO = new ArrayList<QuotationVO>();
		for (Cotizacion cotizacion : quotations) {
			QuotationVO quotationVO = new QuotationVO();
			quotationVO.setCodigoCotizacion(cotizacion.getCodigoCotizacion());
			quotationVO.setFechaCotizacion(cotizacion.getFechaCotizacion());
			quotationVO.setFechaEvento(cotizacion.getFechaEvento());
			quotationVO.setHoras(cotizacion.getHoras());
			quotationVO.setIdCotizacion(cotizacion.getIdCotizacion());
			quotationVO.setValidezOferta(cotizacion.getValidezOferta());
			quotationsVO.add(quotationVO);
		}
		return quotationsVO;
	}

	public QuotationCreateResponseVO create() {
		// TODO Auto-generated method stub
		return null;
	}
}
