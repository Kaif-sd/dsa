package Tree.Maximum_Depth_of_Binary_Tree;

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

public class Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(3);
        tree.root.left=new Node(9);
        tree.root.right=new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        System.out.println(inOrder(tree.root ,0));
    }

    public static int inOrder(Node root , int result){
        if(root == null){
            return result;
        }
        int leftDepth = inOrder(root.left , result+1);
        int rightDepth = inOrder(root.right , result+1);
        return Math.max(leftDepth, rightDepth);
    }
}

// output :-
// 3

//Explaination :-
//  1. Maximum Depth of Binary Tree
//  Given the root of a binary tree, return its maximum depth.
//  A binary tree's maximum depth is the number of nodes along the
//  longest path from the root node down to the farthest leaf node.
//  Input: root = [3,9,20,null,null,15,7]
//  Output: 3