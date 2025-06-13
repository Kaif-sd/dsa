package Tree.Binary_Tree_Maximum_Path_Sum;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    Node root;
    public BinaryTree(){
        root = null;
    }

    public void inorderTraversal(){
        inorder(this.root);
    }

    public void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }
}

public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
        System.out.println("hii");
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        System.out.println(findMaxPathSum(tree1.root));
    }

    public static int findMaxPathSum(Node node){
        if(node == null){
            return 0;
        }
        int z = findMaxPathSum(node.left);
        int y = findMaxPathSum(node.right);

        return node.data + z+y;
    }
}
