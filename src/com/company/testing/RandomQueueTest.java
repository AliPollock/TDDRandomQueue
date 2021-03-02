package com.company.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.company.RandomQueue;

import java.util.NoSuchElementException;
import java.util.Random;

class RandomQueueTest {

    private RandomQueue randomQueue = new RandomQueue(new String[]{"zero", "one", "two", "three", "four"});
    private RandomQueue randomQueue2 = new RandomQueue(new String[]{"zero", "one", "two", "three", "four"});

    public void setDefaults() {
        randomQueue.setQueue(new String[]{"zero", "one", "two", "three", "four"});
        randomQueue2.setQueue(new String[]{"zero", "one", "two", "three", "four"});
//        System.out.println(randomQueue.toString());

    }

    @BeforeEach
    void setUp() {
        setDefaults();
    }

    @AfterEach
    void tearDown() {
        setDefaults();
    }

    @Test
    void add() {
        randomQueue.remove();
        System.out.println(randomQueue.toString());
        randomQueue.add("six");

        assertEquals(5, randomQueue.size());
    }

    @Test
    void remove() {
        randomQueue.remove();
        assertEquals(4, randomQueue.size());

    }

    @Test
    void clear() {
        randomQueue.clear();

        assertEquals(0, randomQueue.size());
    }

    @Test
    void size() {
        int sizeCounter = randomQueue.size();

        assertEquals(5, sizeCounter);
    }

    @Test
    void removeFromEmptyQueue() {
        randomQueue.clear();

        String exceptionText = "";
        try {
            randomQueue.remove();
        } catch(ArrayIndexOutOfBoundsException e) {
            exceptionText = e.toString();
        }

        System.out.println(randomQueue.toString());

        System.out.println("exceptionText: " + exceptionText);
        assertNotEquals("", exceptionText);
    }

    @Test
    void addToFullQueue() {

        String exceptionText = "";
        try {
            randomQueue.add("six");
        } catch(ArrayIndexOutOfBoundsException e) {
            exceptionText = e.toString();
        }

        assertNotEquals("", exceptionText);
    }

    @Test
    void randomness(){
        try {
            randomQueue.remove();
            randomQueue.add("six");
            randomQueue.remove();
            randomQueue.add("seven");
            randomQueue.remove();
            randomQueue.add("eight");
            randomQueue.remove();
            randomQueue.add("nine");
            randomQueue.remove();
            randomQueue.add("ten");
            randomQueue.remove();
            randomQueue.add("eleven");

            randomQueue2.remove();
            randomQueue2.add("six");
            randomQueue2.remove();
            randomQueue2.add("seven");
            randomQueue2.remove();
            randomQueue2.add("eight");
            randomQueue2.remove();
            randomQueue2.add("nine");
            randomQueue2.remove();
            randomQueue2.add("ten");
            randomQueue2.remove();
            randomQueue2.add("eleven");

            assertNotEquals(randomQueue.toString(), randomQueue2.toString());
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}