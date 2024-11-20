package com.example.feigndemo.inner_classes.local_inner_class;

import java.util.ArrayList;
import java.util.Iterator;

public class TitleList {
    private ArrayList<String> titleList = new ArrayList<>();

    public void addTitle(String title) {
        titleList.add(title);
    }

    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
        class TitleIterator implements Iterator<String> {

            int count = 0;

            @Override
            public boolean hasNext() {
                return (count < titleList.size());
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        }
        TitleIterator titleIterator = new TitleIterator();
        return titleIterator;
    }
}

class TitleListTest {

    public static void main(String[] args) {
        TitleList titleList = new TitleList();
        titleList.addTitle("Java");
        titleList.addTitle("Python");
        titleList.addTitle("C++");

        Iterator<String> titleIterator = titleList.titleIterator();
        while (titleIterator.hasNext()) {
            System.out.println(titleIterator.next());
        }
        System.out.println("-----------------------");
        titleList.removeTitle("Python");

        titleIterator = titleList.titleIterator();
        while (titleIterator.hasNext()) {
            System.out.println(titleIterator.next());
        }
    }
}
