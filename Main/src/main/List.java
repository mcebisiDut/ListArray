/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author mcebisim
 */
public class List implements ListArray {

    private int[] list;
    private int lastItem;
    private static final int maxSize = 50;

    List() {
        this(maxSize);
    }

    List(int item) {
        lastItem = -1;
        list = new int[item];
    }

    public boolean add(int item) {
        boolean isSuccessful = false;
        if (!isFull()) {
            lastItem++;
            list[lastItem] = item;
        }

        return isSuccessful;
    }

    public boolean add(int position, int item) {
        boolean isSuccessful = false;
        if (!isFull() && valid(position)) {
            lastItem++;
            openGap(position);
            list[position] = item;
        }
        
        return isSuccessful;
    }

    public int remove(int position) {
        int removedItem = 0;
        if (!isEmpty() && available(position)) {
            removedItem = list[position];
            closeGap(position);
            lastItem--;
        }
        
        return removedItem;
    }

    public void clear() {
        lastItem = -1;
    }

    public int getLength() {
        return lastItem + 1;
    }

    public boolean isFull() {
        return (list.length == lastItem + 1);
    }

    public boolean isEmpty() {
        return (lastItem == -1);
    }

    public void display() {
        for (int index = 0; index <= lastItem ; index++) {
            System.out.println(list[index]);
        }
    }

    private boolean valid(int position) {
        return (position > -1 && position <= lastItem + 1);
    }

    private void openGap(int position) {
        for (int index = lastItem; index > position; index--) {
            list[index] = list[index - 1];
        }
    }

    private boolean available(int position) {
        return (position > -1 && position <= lastItem);
    }

    private void closeGap(int position) {
        for (int index = position; index < lastItem; index++) {
            list[index] = list[index + 1];
        }
    }
}
