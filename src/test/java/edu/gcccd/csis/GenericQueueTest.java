package edu.gcccd.csis;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class GenericQueueTest {

    GenericQueue<Integer> genericQueue = new GenericQueue<>();

    @Test
    public void lengthTest() {
        assertEquals(0,genericQueue.length());
    }

    @Test
    public void enqueueTest1() {
        genericQueue.enqueue(1);
        assertEquals(1,genericQueue.length());
    }

    @Test
    public void enqueueTest2() {
        genericQueue.enqueue(1);
        genericQueue.enqueue(2);
        assertEquals(2,genericQueue.length());
        assertEquals("[1, 2]", genericQueue.toString());
    }

    @Test
    public void enqueueTest3() {
        for (int x=1; x<=10; x++) {
            genericQueue.enqueue(x);
        }
        assertEquals(10,genericQueue.length());
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", genericQueue.toString());

    }

    @Test
    public void dequeueTest1() {
        for (int x=1; x<=10; x++) {
            genericQueue.enqueue(x);
        }
        assertEquals(10,genericQueue.length());
        genericQueue.dequeue();
        assertEquals(9,genericQueue.length());
    }

    @Test
    public void dequeueTest2() {
        for (int x=1; x<=3; x++) {
            genericQueue.enqueue(x);
        }
        assertEquals(3,genericQueue.length());
        assertEquals("[1, 2, 3]", genericQueue.toString());
        genericQueue.dequeue();
        assertEquals(2,genericQueue.length());
        assertEquals("[2, 3]", genericQueue.toString());
        genericQueue.dequeue();
        assertEquals(1,genericQueue.length());
        assertEquals("[3]", genericQueue.toString());
        genericQueue.dequeue();
        assertEquals(0,genericQueue.length());
    }

    @Test (expected = NoSuchElementException.class)
    public void dequeueTest3() {
        genericQueue.enqueue(1);
        assertEquals(1,genericQueue.length());
        genericQueue.dequeue();
        assertEquals(0,genericQueue.length());
        genericQueue.dequeue();

    }



}
