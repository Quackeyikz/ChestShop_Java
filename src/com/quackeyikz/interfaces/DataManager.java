package com.quackeyikz.interfaces;

import java.util.List;

public interface DataManager<T> {
        T commands(String a[], List<T> t);
        void up();
        void down();
        void insert(T t);
        void delete(T t);
        T find(String s);
}
