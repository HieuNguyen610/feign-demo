package com.example.feigndemo.functional_interface.function;

import com.example.feigndemo.reflection.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtils {
    public static <T> void forEach(List<T> list, Consumer<? super T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<T>();
        for (T item: list) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    public static <T, R> List<R> map(List<T> list, Function<? super T, R> function) {
        List<R> mappedList = new ArrayList<R>();
        for (T item: list) {
            mappedList.add(function.apply(item));
        }
        return mappedList;
    }
}

class FunctionUtilsTest {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "John"));
        persons.add(new Person(2, "Alice"));
        persons.add(new Person(3, "Bob"));

        FunctionUtils.forEach(persons, p -> System.out.println(p));

        List<Person> personNameContainO = FunctionUtils.filter(persons, p -> p.getName().contains("o"));
        System.out.println(personNameContainO);

        List<String> personNames = FunctionUtils.map(persons, p -> p.getName());
        System.out.println(personNames);
    }
}
