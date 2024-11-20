package com.example.feigndemo.annotation.table;

public @interface Status {
    boolean approved() default false;
    String approvedBy();
    String approvedOn();
}
