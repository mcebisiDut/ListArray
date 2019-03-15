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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListArray MyList = new List(20);
        MyList.add(20);
        MyList.add(20);
        MyList.add(1,30);
        MyList.display();
        System.out.println("===========================");
        MyList.remove(1);
        MyList.display();
        System.out.println("===========================");
        System.out.println(MyList.getLength());
        MyList.clear();
        MyList.display();
    }
    
}
