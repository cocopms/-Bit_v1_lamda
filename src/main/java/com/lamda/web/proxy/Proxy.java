package com.lamda.web.proxy;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function; //스프링이 아닌 자바 것을 쓸 것
import java.util.function.Predicate;

@Component("pxy") @Lazy //타입정의, pxy는 고정 : shallow copy(또다른게 없음)
public class Proxy {
    //타입 통일
    //크롤링하는 모든 것을 String으로 만들겠다
    public String string(Object param) { //Object: 주소값
        //들어오는 Object -> 나가는 String으로 변환
        Function<Object, String> f = String :: valueOf;
        //파라미터, 리턴타입
        return f.apply(param);
    }

    public int integer(String s) {
        Function<String, Integer> f = Integer :: parseInt; //객체라서 대문자
                //(String s) -> Integer.parseInt(s);
        return f.apply(s);
    }
    public boolean equals(String t, String u) {
        BiPredicate<String, String> f = String :: equals;
        return f.test(t, u);
    }

    public void print(String t) {
        /*Runnable r = () -> System.out.println("프린트");*/
        Consumer<String> c = System.out::print;
        c.accept(t);
    }
}//외부에선 pxy.string()으로 쓸 수 있음