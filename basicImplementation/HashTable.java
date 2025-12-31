package basicImplementation;

import java.util.*;

public class HashTable<K, V> {

    private class Node {
        
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private int n; // No of nodes inside a Hashtable(Linkedlist)
    private int m; // Size of Hashtable 
    private final float load = 0.75f;
    // Declaration
    private LinkedList<Node>[] arr;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.n = 0;
        this.m = 2;
        // Intitlization
        arr = new LinkedList[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % arr.length);
    }

    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<Node> temp = arr[index];
        for (Node node : temp) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<Node> temp = arr[index];
        for (Node node : temp) {
            if (node.key.equals(key)) {
                node.value = value;
                System.out.println("Data is already present at key" + node.key + " & Updated Value is " + node.value);
                return;
            }
        }
        Node node = new Node(key, value);
//         🔴 Root Cause: Integer Division
// Your code
// float load = this.n / this.m;

// Both n and m are int.
// 👉 In Java:
// int / int = int
// So:
// 1 / 2 = 0
// 2 / 3 = 0
// 3 / 4 = 0
// Only after division, the result is converted to float.
// That’s why load is always 0 until n >= m.
// ✅ Correct Fix (MANDATORY)
// Cast either operand to float or double.
// ✅ Best Practice
// float currentLoad = (float) n / m;
// or
// float currentLoad = n / (float) m;
        // Check LoadFactor 
        float load = this.n / (float) this.m;
        System.out.println(load);
        if (load > this.load) {
            reHash();
        }
        temp.add(node);
        n++;
        System.out.println("Data is entered of Given Value" + node.key + " " + node.value);
    }

    // Java does NOT allow generic array creation
    // new LinkedList[m*2] → raw type
    // Assigning it to LinkedList<Node>[] causes unchecked conversion
    @SuppressWarnings("unchecked")
    void reHash() {
        System.out.println("Rehashing Started");

        // private LinkedList<Node>[] arr;
        // The local arr shadows (hides) the class field → confusing + risky.
        LinkedList<Node>[] oldArr = arr;

        m = m * 2;
        n=0;
        arr = new LinkedList[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }

        // Reinsert elements (REAL rehashing)
        for (LinkedList<Node> ll : oldArr) {
            for (Node node : ll) {
                put(node.key, node.value);
            }
        }

        System.out.println("Rehashing Completed");
    }

    public V delete(K key) {
        int index = hashFunction(key);
        LinkedList<Node> temp = arr[index];

        Node temp2 = null;

        for (Node node : temp) {
            if (node.key.equals(key)) {
                temp2 = node;
            }
        }

        temp.remove(temp2);
        n--;
        return null;
    }

    public void display() {
        for (LinkedList<Node> linkedList : arr) {
            for (Node node : linkedList) {
                System.out.println(node.key + "=" + node.value);
            }
        }
    }
}
