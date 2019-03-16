package main;
/**
 *
 * @author mcebisim
 */
public class Main {

    public static void main(String[] args) {
        
        ListArray MyList = new List(2);
        MyList.add(20);
        MyList.add(20);
        MyList.add(1,30);
        MyList.display();
        System.out.println("===========================");
        MyList.replace(0, 10);
        MyList.display();
        System.out.println(MyList.contains(40));
        System.out.println(MyList.getItem(0));
        System.out.println("===========================");
        MyList.remove(1);
        MyList.display();
        System.out.println("===========================");
        System.out.println(MyList.getLength());
        MyList.clear();
        MyList.display();
    }
    
}
