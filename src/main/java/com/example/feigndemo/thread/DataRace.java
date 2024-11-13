package com.example.feigndemo.thread;


import org.postgresql.core.Parser;

public class DataRace {
    private static Parser parser;
    public static Parser getInstance() {
        if (parser == null) {
            parser = new Parser();
        }
        return parser;
    }
}
