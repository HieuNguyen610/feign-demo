package com.example.feigndemo.generics;

public class LowerBound {

    public static <T> void copy(Wrapper<T> source, Wrapper<? super T> destination) {
        T value = source.getRef();
        destination.setRef(value);
    }

    public static <T> void swap(Wrapper<T> source, Wrapper<? super T> destination) {
        T temp = source.getRef();
        source.setRef((T) destination.getRef());
        destination.setRef(temp);
    }

    public static void main(String[] args) {
        Wrapper<Object> objWrapper = new Wrapper<>(new Object());
        Wrapper<String> strWrapper = new Wrapper<>("Hello");
        copy(strWrapper, objWrapper);
        System.out.println(objWrapper);
        System.out.println(strWrapper);
    }
}
