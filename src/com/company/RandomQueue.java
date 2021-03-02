package com.company;

import java.util.Arrays;
import java.util.Random;

public class RandomQueue {

    String[] queue;

    public RandomQueue() {
    }

    public RandomQueue(String[] queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "RandomQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public void add(String str) {
        if( queue[4] != null){
            throw new ArrayIndexOutOfBoundsException("Array is full, cannot add an element");
        }
        for (int i= 0; i<5; i++) {
            if(queue[i] == null) {
                queue[i] = str;
                return;
            }
        }

    }

    public String remove() {
        Random rand = new Random();
        int randint = rand.nextInt(5);
        String returnValue = queue[randint];
        if (queue[0] == null ) {
            throw new ArrayIndexOutOfBoundsException("Array is empty, cannot remove an element");
        }
        queue[randint] = null;
        for(int i = randint; i< (this.size()); i++) {
            if (i==4) {
                queue[i] = null;
            } else {
                queue[i] = queue[i+1];
            }
        }

        return returnValue;
    }

    public void clear() {
        for (int i = 0; i< 5; i++) {
            queue[i] = null;
        }
    }

    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i< 5; i++) {
            if(queue[i] != null) {
                sizeCounter++;
            }
        }

        return sizeCounter;
    }

    public void setQueue(String[] queue) {
        this.queue = queue;
    }

}
