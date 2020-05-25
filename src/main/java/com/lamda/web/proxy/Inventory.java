package com.lamda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component @Lazy
public class Inventory<T> {
    private ArrayList<T> inventory;
    //add, clear, get(i), get(list), size, newInventory

    public Inventory() { inventory = new ArrayList<>(); }

    public void add(T t) { inventory.add(t); }

    public ArrayList<T> get() {
        return inventory;
    }

    public T get(int i) {
        Function<Integer, T> f = inventory :: get; //f의 리턴값 : function은 무조건 parameter, return값 있음
        //Function<Integer, T> f = p -> inventory.get(p); what is 'p'? function은 반드시 return값을 갖는데 어떤 타입이든 상관 없음 : 다형성
        return f.apply(i);
    }

    public int size() { return inventory.size(); }

    public void clear() { inventory.clear(); }

    public void newInventory() { inventory = new ArrayList<T>(); }
}