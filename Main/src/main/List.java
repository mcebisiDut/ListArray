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
        if (valid(position)) {
            lastItem++;
            openGap(position);
            list[position] = item;
        }

        return isSuccessful;
    }

    public int remove(int position) {
        int removedItem = 0;
        if (available(position)) {
            removedItem = list[position];
            closeGap(position);
            lastItem--;
        }

        return removedItem;
    }

    public boolean replace(int position, int item) {
        boolean isSuccessful = false;
        if (available(position)) {
            list[position] = item;
            isSuccessful = true;
        }
        
        return isSuccessful;
    }

    public boolean contains(int item) {
        boolean isAvailable = false;
        if (!isEmpty()) {
            isAvailable = search(item);
        }

        return isAvailable;
    }

    public int getItem(int position) {
        int value = 0;
        if (available(position)) {
            value = list[position];
        }
        
        return value;
    }

    public int getLength() {
        return (lastItem + 1);
    }

    public void display() {
        for (int index = 0; index <= lastItem; index++) {
            System.out.println(list[index]);
        }
    }

    public void clear() {
        lastItem = -1;
    }

    public boolean isFull() {
        return (list.length == lastItem + 1);
    }

    public boolean isEmpty() {
        return (lastItem == -1);
    }

    private boolean valid(int position) {
        return (!isFull() && position > -1 && position <= lastItem + 1);
    }

    private void openGap(int position) {
        for (int index = lastItem; index > position; index--) {
            list[index] = list[index - 1];
        }
    }

    private boolean available(int position) {
        return (!isEmpty() && position > -1 && position <= lastItem);
    }

    private void closeGap(int position) {
        for (int index = position; index < lastItem; index++) {
            list[index] = list[index + 1];
        }
    }

    private boolean search(int item) {
        boolean contains = false;
        for (int index = 0; index <= lastItem; index++) {
            if (list[index] == item) {
                contains = true;
                index = lastItem;
            }
        }

        return contains;
    }
}
