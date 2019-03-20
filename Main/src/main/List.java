package main;

/**
 *
 * @author mcebisim
 */
public class List implements ListArray {

    private int[] list;
    private int lastPosition;
    private static final int maxSize = 50;

    List() {
        this(maxSize);
    }

    List(int item) {
        lastPosition = -1;
        list = new int[item];
    }

    public boolean add(int item) {
        boolean isSuccessful = false;
        if (!isFull()) {
            lastPosition++;
            list[lastPosition] = item;
        }

        return isSuccessful;
    }

    public boolean add(int position, int item) {
        boolean isSuccessful = false;
        if (valid(position)) {
            lastPosition++;
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
            lastPosition--;
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

    public int getMax() {
        int max = list[0];
        for (int index = 0; index <= lastPosition; index++) {
            if (list[index] > max) {
                max = list[index];
            }
        }

        return max;
    }

    public int getMin() {
        int min = list[0];
        for (int index = 0; index <= lastPosition; index++) {
            if (list[index] < min) {
                min = list[index];
            }
        }

        return min;
    }

    public int getLength() {
        return (lastPosition + 1);
    }

    public void display() {
        for (int index = 0; index <= lastPosition; index++) {
            System.out.println(list[index]);
        }
    }

    public void clear() {
        lastPosition = -1;
    }

    public boolean isFull() {
        boolean isFull = (list.length == lastPosition + 1);
        if (isFull) {
            resizeArray();
            isFull = (list.length == lastPosition + 1);
        }
        return isFull;
    }

    public boolean isEmpty() {
        return (lastPosition == -1);
    }

    private void resizeArray() {
        int[] resizedList = new int[list.length * 2];
        for (int index = 0; index < list.length; index++) {
            resizedList[index] = list[index];
        }
        list = resizedList;
    }

    private boolean valid(int position) {
        return (!isFull() && position > -1 && position <= lastPosition + 1);
    }

    private void openGap(int position) {
        for (int index = lastPosition; index > position; index--) {
            list[index] = list[index - 1];
        }
    }

    private boolean available(int position) {
        return (!isEmpty() && position > -1 && position <= lastPosition);
    }

    private void closeGap(int position) {
        for (int index = position; index < lastPosition; index++) {
            list[index] = list[index + 1];
        }
    }

    private boolean search(int item) {
        boolean contains = false;
        for (int index = 0; index <= lastPosition; index++) {
            if (list[index] == item) {
                contains = true;
                index = lastPosition;
            }
        }

        return contains;
    }
}
