package com.lamda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Lazy // -> 내가 사용할 때 나와 :)
public class Box<T> { //T는 어떤 타입이든 상관 없으나 해당 타입만 들어올 수 있음
    private HashMap<String, T> box; //제네릭 hashMap

    //생성자 초기화
    public Box() { box = new HashMap<>(); }

    //put, get(k), get(map), size, clear
    public void put(String s, T t) { box.put(s, t); } //가독성보다 효율성을 중시하는 시대

    public T get(String k) { //String으로 들어와 T로 나간다
/*        Function<String, T> s = p -> box.get(p);*/
        Function<String, T> s = box::get; //813
        return s.apply(k);
    }

    public HashMap<String, T> get() { return box; }

    public int size() {
/*        Supplier<Integer> f = box :: size;
        return f.get();*/
        return box.size();
    }

    public void clear() { box.clear(); }

    public void newBox() { box = new HashMap<String, T>(); } //또다른, 새로운 박스가 필요할 때
}
