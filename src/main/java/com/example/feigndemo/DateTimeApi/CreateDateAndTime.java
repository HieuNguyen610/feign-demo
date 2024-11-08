package com.example.feigndemo.DateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CreateDateAndTime {

    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1992, 10, 06);
        LocalTime birthTime = LocalTime.of(20, 10, 00);
        LocalDateTime dateTime = LocalDateTime.of(birthDay, birthTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC+2"));
        System.out.println(birthDay);
        System.out.println(birthTime);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);
    }
}
