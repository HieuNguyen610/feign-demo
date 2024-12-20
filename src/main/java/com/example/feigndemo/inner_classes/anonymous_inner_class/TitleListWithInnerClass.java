package com.example.feigndemo.inner_classes.anonymous_inner_class;

import java.util.ArrayList;
import java.util.Iterator;

public class TitleListWithInnerClass {
    private final ArrayList<String> titleList = new ArrayList<>();

    public void addTitle(String title) {
        titleList.add(title);
    }

    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
        Iterator<String> iterator = new Iterator<String>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < titleList.size();
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        };

        return iterator;
    }
}
