package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.nexos.backend.api.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
