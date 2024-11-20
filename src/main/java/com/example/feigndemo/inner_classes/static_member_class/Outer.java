package com.example.feigndemo.inner_classes.static_member_class;

import com.example.feigndemo.inner_classes.static_member_class.Outer.StaticInner;

public class Outer {
    private static int outer = 0;
    public static class StaticInner {

        public int getOuter() {
            return outer;
        }
    }
}

class TestClass {

    public static void main(String[] args) {
        Outer.StaticInner inner = new Outer.StaticInner();
        StaticInner other = new StaticInner();
        inner.getOuter();
        other.getOuter();

    }
}
