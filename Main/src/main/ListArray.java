package main;
/**
 *
 * @author mcebisim
 */
public interface ListArray {
    
    public boolean add(int item);
    public boolean add(int position, int item);
    public int remove(int position);
    public boolean replace(int position, int item);
    public boolean contains(int item);
    public int getItem(int position);
    public int getLength();
    public void display();
    public void clear();
    public boolean isFull();
    public boolean isEmpty();
}
