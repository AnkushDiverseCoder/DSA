package segmentTree;

import java.util.Scanner;

public class BitwiseSegmentTree {

    private class Node {

        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    public Node root;

    // Array Size -> 2^n
    // Odd -> start with or 
    // Even -> start with xor
    public void create(int[] arr, int n) {
        boolean or = false;
        if (n % 2 != 0) {
            or = true;
        }
        this.root = createBitwiseSegmentTree(arr, 0, arr.length-1, or);
    }

    private Node createBitwiseSegmentTree(int[] arr, int start, int end, boolean or) {

        if (start == end) {
            Node node = new Node(start, end);
            node.left = null;
            node.right = null;
            node.data = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        Node node = new Node(start, end);

        node.left = createBitwiseSegmentTree(arr, start, mid, !or);
        node.right = createBitwiseSegmentTree(arr, mid + 1, end, !or);

        if (or) {
            node.data = node.left.data | node.right.data;
        }
        if (!or) {
            node.data = node.left.data ^ node.right.data;
        }
        return node;
    }

    public void update(int target, int value, int n) {
        boolean or = false;
        if (n % 2 != 0) {
            or = true;
        }
        target--;
        this.root = this.update(this.root, target, value, or);
    }

    private Node update(Node node, int target, int value, boolean or) {
        if (node.startInterval == target && node.endInterval == target) {
            node.data = value;
            return node;
        }
        if (node.left == null && node.right == null) {
            return node;
        }

        node.left = update(node.left, target, value, !or);
        node.right = update(node.right, target, value, !or);

        if (or) {
            node.data = node.left.data | node.right.data;
        }
        if (!or) {
            node.data = node.left.data ^ node.right.data;
        }
        return node;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[(int)Math.pow(2, n)];
        int i=0;
        while(i<arr.length){
            arr[i] = sc.nextInt();
            i++;
        }
        BitwiseSegmentTree bst = new BitwiseSegmentTree();
        bst.create(arr,n);
        for (i = 0; i < q; i++) {
            bst.update(sc.nextInt(), sc.nextInt(), n);
            System.out.println(bst.root.data);
        }
    }
}
