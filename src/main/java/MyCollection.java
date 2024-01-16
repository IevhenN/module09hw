import java.util.*;

public class MyCollection {
    public static void main(String[] args) {

// MyLinkedList===============================================================

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Fourth");
        linkedList.add("Fifth");

        System.out.println("linkedList.toString() = " + linkedList.toString());

        System.out.println("linkedList.get(1) = " + linkedList.get(1));

        linkedList.remove(15);
        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.remove(0);
        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.remove(3);
        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.remove(1);
        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.clear();
        System.out.println("linkedList.toString() = " + linkedList.toString());


        // MyArrayList===============================================================
        MyArrayList<String> arrayList = new MyArrayList<>();
        System.out.println("arrayList.toString() = " + arrayList.toString());

        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");
        arrayList.add("16");
        arrayList.add("17");
        arrayList.add("18");
        arrayList.add("19");
        System.out.println("arrayList.toString() = " + arrayList.toString());

        System.out.println("arrayList.get(1) = " + arrayList.get(1));

        arrayList.remove(1);
        System.out.println("arrayList.toString() = " + arrayList.toString());

        arrayList.remove(0);
        System.out.println("arrayList.toString() = " + arrayList.toString());

        arrayList.remove(2);
        System.out.println("arrayList.toString() = " + arrayList.toString());

        System.out.println("arrayList.size() = " + arrayList.size());

        arrayList.clear();
        System.out.println("arrayList.toString() = " + arrayList.toString());


        // MyQueue===============================================================
        MyQueue<String> queue = new MyQueue<>();
        System.out.println("queue.toString() = " + queue.toString());

        queue.add("Queue 01");
        queue.add("Queue 02");
        queue.add("Queue 03");
        queue.add("Queue 04");
        queue.add("Queue 05");
        queue.add("Queue 06");
        System.out.println("queue.toString() = " + queue.toString());

        System.out.println("queue.size() = " + queue.size());

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.toString() = " + queue.toString());

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.toString() = " + queue.toString());

        queue.clear();
        System.out.println("queue.toString() = " + queue.toString());

        // MyStack===============================================================
        MyStack<String> stack = new MyStack<>();
        System.out.println("stack.toString() = " + stack.toString());

        stack.push("stack 01");
        stack.push("stack 02");
        stack.push("stack 03");
        stack.push("stack 04");
        stack.push("stack 05");
        stack.push("stack 06");
        System.out.println("stack.toString() = " + stack.toString());

        System.out.println("stack.size() = " + stack.size());

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.toString() = " + stack.toString());

        System.out.println("stack.poll() = " + stack.poll());
        System.out.println("stack.toString() = " + stack.toString());

        stack.remove(4);
        System.out.println("stack.toString() = " + stack.toString());

        stack.clear();
        System.out.println("stack.toString() = " + stack.toString());


        // MyStack===============================================================
        Car car1 = new Car("Ford","Focus","11111");
        Car car2 = new Car("Renault","Megan","22222");
        Car car3 = new Car("Toyota","Camry","33333");
        Car car4 = new Car("BMW","X5","44444");

        LicenseNumber number1 = new LicenseNumber("XA 0001 XA");
        LicenseNumber number2 = new LicenseNumber("KI 0002 KI");
        LicenseNumber number3 = new LicenseNumber("NM 0003 NM");
        LicenseNumber number4 = new LicenseNumber("ZP 0004 ZP");

        MyHashMap <Car,LicenseNumber> map = new MyHashMap<>();

        map.put(car1,number1);
        map.put(car2,number2);
        map.put(car3,number3);
        map.put(car4,number4);

        System.out.println("map.toString() = " + map.toString());

        map.remove(car3);

        System.out.println("map.toString() = " + map.toString());

        System.out.println("map.get(ca1) = " + map.get(car1));

        System.out.println("map.size() = " + map.size());

        map.clear();
        System.out.println("map.clear() - map.toString() = " + map.toString());
        System.out.println("map.size() = " + map.size());
    }
}
