package com.urlnavigator.api.service;

import com.urlnavigator.api.entity.UrlEntity;

public interface UrlService {

	UrlEntity findByUrl(String url);
	Iterable<UrlEntity> findAll();
	
}
