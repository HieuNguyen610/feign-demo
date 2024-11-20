package com.example.feigndemo.generics;

import com.example.feigndemo.reflection.Person;

public class Wrapper<T> {

    private T ref;

    public Wrapper(T ref) {
        this.ref = ref;
    }

    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
            "ref=" + ref.toString() +
            '}';
    }
}

class WrapperTest {

    public static void main(String[] args) {
        Wrapper<String> strWrap = new Wrapper<String>("Hello");
        strWrap.setRef("a String");

        Wrapper<Object> objWrap = new Wrapper<Object>("a string object");
    }
}
