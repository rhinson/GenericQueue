package edu.gcccd.csis;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GenericQueue<E> {

    private final ArrayList<E> elements;

    public GenericQueue() {
        this(10);
    }

    public GenericQueue(int capacity) {
        int initCapacity = capacity > 0 ? capacity : 10;
        elements = new ArrayList<E>(initCapacity);
    }

    public void enqueue(E queueValue) {
        elements.add(queueValue);
    }

    public E dequeue() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Queue is empty, can't dequeue");
        }
        return elements.remove(0);
    }

    // current length of the queue
    public int length() {
        return elements.size();
    }

    @Override
    public String toString() {
        return String.format(String.valueOf(elements));
    }

}