package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Cotizacion;

@Repository
public interface CotizacionRepository extends CrudRepository<Cotizacion, Long>{

}
