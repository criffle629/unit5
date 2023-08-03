package com.unit5;

public class Stack<T> {

    private T[] stack = (T[]) new Object[25];
    private int pointer = 0;

    public void push(T value){
        if (pointer == stack.length)
            resize();

        stack[pointer] = value;
        pointer++;
    }

    public T pop(){
        if (isEmpty()) return null;

        T value = stack[pointer];
        stack[pointer] = null;
        pointer--;

        return value;
    }

    public T peek(){
        if (isEmpty()) return null;

        return stack[pointer - 1];
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    public int size(){
        return pointer;
    }

    public int capacity(){
        return stack.length;
    }

    private void resize(){
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
