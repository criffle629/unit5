package com.unit5;

public class LinkedList<T> {
    public LinkedList<T> next = null;
    public T value;
    
    public LinkedList(T value) {
        this.value = value;
    }

    public LinkedList() {
        value = null;
    }    
}
