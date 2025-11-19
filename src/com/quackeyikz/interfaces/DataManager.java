package com.quackeyikz.interfaces;

public interface DataManager<T> {
        void up();
        void down();
        void insert(T t);
        void delete(T t);
        void find(T t);
}
