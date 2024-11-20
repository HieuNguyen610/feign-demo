package com.example.feigndemo.functional_interface.function.lexical_scope;

public class LexicalScope {

    public static void main(String[] args) {
        LexicalScope scope = new LexicalScope();
        Printer printer = (message ) -> System.out.println(message);
        printer.print("Hello world");
    }

}

@FunctionalInterface
interface Printer {
    void print(String message);
}
