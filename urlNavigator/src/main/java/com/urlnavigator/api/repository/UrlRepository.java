package com.urlnavigator.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urlnavigator.api.entity.UrlEntity;

@Repository
public interface UrlRepository extends CrudRepository<UrlEntity, Integer>{

	UrlEntity findByUrl(String url);
	
}
