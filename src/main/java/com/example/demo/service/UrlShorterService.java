package com.example.demo.service;

import com.example.demo.dao.UrlMappingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShorterService {

    /*
        Need of UrlMapping Entity

        1. Encapsulation and Readability:
            The UrlMapping class acts as a container for the relationship between the original URL and its short version.
            This encapsulation can improve the readability of your code, making it clear that these two pieces of information are related.

        2.Future Extensibility:
            If, in the future, you need to add more properties or metadata related to the URL mapping (e.g., creation timestamp,
            user who created the short URL, expiration date), having a dedicated class makes it easier to extend without modifying
            the existing Map<String, String> structure.

        3. Code Maintainability:
            By using a dedicated class, your code becomes more modular and easier to maintain. If changes are needed, they can be confined
            to the UrlMapping class, and the rest of the code that uses it won't be affected.
     */

    @Autowired
    UrlMappingDao urlMappingDao;
    public String createShortUrl(String originalUrl) {
        return urlMappingDao.createShortUrl(originalUrl);
    }

    public String getOriginalUrl(String shortUrl) {
        String originalUrl = urlMappingDao.getOriginalUrl(shortUrl);
        return originalUrl;
    }
}
