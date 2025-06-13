package Tree.Same_Tree;

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
}

public class Same_Tree {

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(3);
        tree2.root.right = new Node(3);
        System.out.println(isTreeSame(tree1.root, tree2.root));

    }
    public static boolean isTreeSame(Node node1 , Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        if(node1.data != node2.data){
            return false;
        }

        boolean left = isTreeSame(node1.left, node2.left);
        boolean right = isTreeSame(node1.right, node2.right);
        return left && right;
    }

}
