package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.QuotationCombo;
import com.nexos.backend.api.model.QuotationComboPK;

@Repository
public interface QuotationComboRepository extends CrudRepository<QuotationCombo, QuotationComboPK>{

}
