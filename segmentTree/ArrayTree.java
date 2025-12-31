package segmentTree;

public class ArrayTree {

    private void generateTree(int[] nums, int[] seg ,int start, int end){
        if(start==end){
            seg[start] = nums[start];
            return;
        }

        int mid = start + (end-start)/2;
        // 2*N+1
        generateTree(nums,seg,start,mid);
        // 2*N+2
        generateTree(nums,seg,mid+1,end);

        seg[start] = seg[2*];
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
}
