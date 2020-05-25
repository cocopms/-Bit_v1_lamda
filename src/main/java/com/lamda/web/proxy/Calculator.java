package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy
public class Calculator {

    @Autowired Box<Integer> box; //해당 공급은 본체에서 받음

    public int sum(int a, int b) {
        box.put("result", a+b);
        return box.get("result");
    }
}