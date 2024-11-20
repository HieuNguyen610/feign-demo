package com.example.feigndemo.generics.exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static void main(String[] args) {
        Integer[] n1 = {1, 2};
        Integer[] n2 = {3, 4};
        Integer[] m = merge(n1, n2);
        System.out.println(Arrays.toString(m));
        String[] s1 = {"one", "two"};
        String[] s2 = {"three", "four"};
        String[] t = merge(s1, s2);
        System.out.println(Arrays.toString(t));
        List<Number> list = new ArrayList<>();
        add(list, 10, 20, 30L, 40.5F, 50.9);
        System.out.println(list);
    }

    public static <T> T[] merge(T[] a, T[] b) {
        T[] mergedArray = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);
        System.arraycopy(a, 0, mergedArray, 0, a.length);
        System.arraycopy(b, 0, mergedArray, a.length, b.length);
        return mergedArray;
    }

    public static <T extends Number, U extends Number> void add(List<T> list,
        U... elems) {
        /* Your code to add elems to list goes here */
        for (U elem : elems) {
            list.add((T) elem);
        }
    }
}
