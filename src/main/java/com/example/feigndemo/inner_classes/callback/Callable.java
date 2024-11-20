package com.example.feigndemo.inner_classes.callback;

import java.util.ArrayList;

public interface Callable {
    void call();
}

class CallBackTest {
    private final ArrayList<Callable> callables = new ArrayList<>();

    public static void main(String[] args) {
        CallBackTest callBackTest = new CallBackTest();
        callBackTest.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Callback 1 called");
            }
        });

        callBackTest.register(new Callable(){
            @Override
            public void call() {
                System.out.println("Callback 2 called");
            }
        });

        callBackTest.register(new Callable(){
            @Override
            public void call() {
                System.out.println("Callback 3 called");
            }
        });

        callBackTest.callback();
    }

    private void callback() {
        for (Callable callable : callables) {
            callable.call();
        }
    }

    public void register(Callable c) {
        this.callables.add(c);
    }
}
