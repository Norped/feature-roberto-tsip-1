package com.urlnavigator.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlnavigator.api.entity.UrlEntity;
import com.urlnavigator.api.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService{
	
	private final UrlRepository urlRepository;
	
	 @Autowired
	    public UrlServiceImpl(UrlRepository urlRepository) {
	        this.urlRepository = urlRepository;
	    }

	 @Override
	 public UrlEntity findByUrl(String url) {
	        return urlRepository.findByUrl(url);
	 }

	@Override
	public Iterable<UrlEntity> findAll() {
		return urlRepository.findAll();
	}

}
