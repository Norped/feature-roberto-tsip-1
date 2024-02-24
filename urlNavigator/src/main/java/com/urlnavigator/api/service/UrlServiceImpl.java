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
			return "Resource with ID " + id + " deleted successfully";
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}






}
