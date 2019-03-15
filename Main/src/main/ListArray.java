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
public interface ListArray {
    public boolean add(int item);
    public boolean add(int position, int item);
    public int remove(int position);
    public void clear();
    public int getLength();
    public void display();
    public boolean isFull();
    public boolean isEmpty();
}
