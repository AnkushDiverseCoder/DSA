package segmentTree;

public class Tree {
    private class Node{
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
    Node root;

    public void createSum(int[] nums,int start,int end){
       this.root = generateTree(nums,start,end);
    }

    private Node generateTree(int[] nums,int start, int end){
        if(start==end){
            Node node = new Node(start,end);
            node.data = nums[start];
            node.left = null;
            node.right = null; 
            return node;
        }
        
        Node node = new Node(start,end);
        int mid = start + (end-start)/2;

        node.left = generateTree(nums,start,mid);
        node.right = generateTree(nums,mid+1,end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void displaySegmentTree(){
        displayNode(this.root);
    }

    private void displayNode(Node node){
        if(node.left==null && node.right == null){
            System.out.println( node.data + "at interval [ "+ node.startInterval + "," + node.endInterval + " ]");
            return;
        }
        
        // current node 
        System.out.println( node.data + "at interval [ "+ node.startInterval + "," + node.endInterval + " ]");
        displayNode(node.left);
        displayNode(node.right);

    }

    // query
    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            // node is ccompletely lying;
            return node.data;
        }

        if(node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }

        return this.query(node.left, qsi,qei) + this.query(node.right,qsi, qei);
    }

    // Update a index 
    public void update(int value, int index){
        this.root.data = this.update(this.root,value,index);
    }

    private int update(Node node, int value, int index){
        if(node.startInterval == index && node.endInterval == index){
            node.data = value;
            return node.data;
        }

        if(  node.startInterval <= index && node.endInterval >= index ){
            node.data = update(node.left, value, index) + update(node.right, value, index);
            return node.data;
        }

        return node.data;
    }
}
