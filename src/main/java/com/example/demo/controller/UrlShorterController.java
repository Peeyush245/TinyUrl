package com.example.demo.controller;

import com.example.demo.constants.UrlConstants;
import com.example.demo.service.UrlShorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstants.URL_BASE_PATH)
public class UrlShorterController {

    @Autowired
    UrlShorterService urlShorterService;

    @PostMapping(UrlConstants.CREATE)
    public String createShortUrl(@RequestParam String originalUrl) {
        return urlShorterService.createShortUrl(originalUrl);
    }

    @GetMapping(UrlConstants.GET)
    public String getOriginalUrl(@RequestParam String shortUrl) {
        return urlShorterService.getOriginalUrl(shortUrl);
    }
}
