package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController {
    @Autowired Crawler crawler;
    @Autowired Box<Object> box;
    @Autowired Proxy pxy;
    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord) {
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        ArrayList<HashMap<String, String>> list = crawler.bugsMusic();
        box.put("list", list);
        pxy.print("++++++++++");
        pxy.print("넘어온 키워드: "+list.size()); //질문
        box.put("count", list.size());
        return box.get();
    }
}