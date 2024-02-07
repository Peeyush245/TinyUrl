package com.example.demo.dao;

import com.example.demo.entities.UrlMapping;
import com.example.demo.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UrlMappingDao {

    private final UrlMappingRepository urlMappingRepository;

    @Autowired
    public UrlMappingDao(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String createShortUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        UrlMapping urlMapping = new UrlMapping(originalUrl, shortUrl);
        urlMappingRepository.save(urlMapping);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        return (urlMapping != null) ? urlMapping.getOriginalUrl() : null;
    }

    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
