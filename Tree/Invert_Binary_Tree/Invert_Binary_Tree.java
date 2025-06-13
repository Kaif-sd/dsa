package Tree.Invert_Binary_Tree;

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

public class Invert_Binary_Tree {
    
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(4);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(7);
        tree1.root.left.left = new Node(1);
        tree1.root.left.right = new Node(3);
        tree1.root.right.left = new Node(6);
        tree1.root.right.right = new Node(9);

        tree1.inorderTraversal();
        tree1.root = invertBinaryTree(tree1.root);
        System.out.println("after inversion of tree:- ");
        tree1.inorderTraversal();
    }

    public static Node invertBinaryTree(Node node){

        if(node == null){
            return null;
        }
              Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        return node;
    }

}
