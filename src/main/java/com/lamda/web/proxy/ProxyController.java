package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/menu")
public class ProxyController {
    @Autowired Crawler crawler;
    @GetMapping("/chart")
    public ArrayList<HashMap<String, String>> CrawlerAll() {
        return crawler.bugsMusic();
    }
}