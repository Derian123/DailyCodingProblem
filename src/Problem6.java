class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {

        this.data = data;
        right = null;
        left = null;
    }

}
public class Problem6 {


     Node root;
     static int count;


     public boolean countUnivalTrees(Node node){

        if(node == null) return true;

        boolean leftNode = countUnivalTrees(node.left);
        boolean rightNode = countUnivalTrees(node.right);

        if(!leftNode || !rightNode) return false;

        if(node.left != null && node.data != node.left.data) return false;

        if(node.right != null && node.data != node.right.data) return false;



        count++;
        return true;

    }

    public void startCount(){
         countUnivalTrees(root);
    }
    public static void main(String[] args) {

        Problem6 p6 = new Problem6();
        p6.root = new Node(0);
        p6.root.left = new Node(1);
        p6.root.right = new Node(0);
        p6.root.right.right = new Node(0);
        p6.root.right.left = new Node(1);
        p6.root.right.left.left = new Node(1);
        p6.root.right.left.right = new Node(1);


        p6.startCount();
        System.out.println(count);


    }
}
