package com.urlnavigator.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlnavigator.api.common.Constants;
import com.urlnavigator.api.entity.UrlEntity;
import com.urlnavigator.api.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService{
	
	private final UrlRepository urlRepository;
	private final Constants constants;
	
	 @Autowired
	    public UrlServiceImpl(UrlRepository urlRepository, Constants constants) {
	        this.urlRepository = urlRepository;
	        this.constants = constants;
	    }

	 @Override
	 public UrlEntity findByUrl(String url) {
	        return urlRepository.findByUrl(url);
	 }

	@Override
	public Iterable<UrlEntity> findAll() {
		return urlRepository.findAll();
	}

	@Override
	public UrlEntity save(UrlEntity urlEntity) {
		return urlRepository.save(urlEntity);
	}

	@Override
	public UrlEntity update(UrlEntity urlEntity) {
		return urlRepository.save(urlEntity);
	}

	@Override
	public String deleteById(Integer id) {
		try {
			urlRepository.deleteById(id);
			return this.constants.DELETE_URL;
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}

}
