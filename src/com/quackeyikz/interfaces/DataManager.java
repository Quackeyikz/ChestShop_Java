package com.quackeyikz.interfaces;

public interface DataManager<T> {
        void commands(String a[]);
        void up();
        void down();
        void insert(T t);
        void delete(T t);
        T find(String s);
}
