package com.example.feigndemo.generics.exercises;

import java.util.LinkedList;
import java.util.List;

public class Stack<E> {
    // Use LinkedList instead of ArrayList
    private final List<E> stack = new LinkedList<>();
    public void push(E e) {
        stack.add(e);
    }
    public E pop() {
        if (stack.size() > 0) {
            return stack.remove(stack.size() - 1);  // Removes and returns the last element
        } else {
            throw new IllegalStateException("Stack is empty");  // Throw an exception if the stack is empty
        }
    }
    public E peek() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);  // Returns the last element without removing it
        } else {
            throw new IllegalStateException("Stack is empty");  // Throw an exception if the stack is empty
        }
    }
    public boolean isEmpty() {
        return stack.isEmpty();  // Returns true if the stack is empty
    }
    public int size() {
        return stack.size();  // Returns the number of elements in the stack
    }
}

class StackTest {

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        System.out.println("Top element: " + integerStack.peek());  // Output: Top element: 3
        System.out.println("Size: " + integerStack.size());  // Output: Size: 3
        integerStack.pop();
        System.out.println("Top element after pop: " + integerStack.peek());  // Output: Top element after pop: 2
        System.out.println("Is stack empty? " + integerStack.isEmpty());  // Output: Is stack empty? false
    }
}