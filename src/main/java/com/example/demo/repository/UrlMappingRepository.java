package com.example.demo.repository;

import com.example.demo.entities.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping save(UrlMapping urlMapping); // Method for inserting a new URL mapping
    UrlMapping findByShortUrl(String shortUrl); // Method for retrieving URL mapping by short URL
}
