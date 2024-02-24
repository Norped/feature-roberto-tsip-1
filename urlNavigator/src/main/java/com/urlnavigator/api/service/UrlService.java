package com.urlnavigator.api.service;

import com.urlnavigator.api.entity.UrlEntity;

public interface UrlService {

	UrlEntity findByUrl(String url);
	
	Iterable<UrlEntity> findAll();
	
	UrlEntity save(UrlEntity urlEntity);
	
	UrlEntity update(UrlEntity urlEntity);

	String deleteById(Integer id);
	
}
