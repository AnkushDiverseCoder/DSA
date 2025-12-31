package segmentTree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        Tree segmentTree = new Tree();
        segmentTree.createSum(arr, 0, arr.length-1);
        // segmentTree.displaySegmentTree();
        // segmentTree.update(14, 3);
        System.out.println(segmentTree.query(1,6 ));
        // segmentTree.displaySegmentTree();
    }
}
