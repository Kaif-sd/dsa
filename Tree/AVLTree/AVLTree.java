package Tree.AVLTree;

class AVLTree {
    
    static class Node{
        int data;
        int height;
        Node left;
        Node right;
        Node(int data){
             this.data =data;
             height =1;
             left = null;
             right = null;
        }
    }
    
    static class tree{
    
        Node root = null;
        
        public Node insert(Node root , int val){
            Node newNode = new Node(val);
            if(root == null){
                root = newNode;
                return root ;
            }
            if(val < root.data){
                root.left = insert(root.left , val);
            }else{
                root.right = insert(root.right , val);
            }
            
            root.height = 1+ Math.max(height(root.left) , height(root.right));
            
            return correction(root);
        }
        

        public Node correction(Node root){
            int bf = balanceFactor(root);
            if(bf > 1 && balanceFactor(root.left) > 0){
                //do LL imbalance 
                //do rightroattion 
                return rightRotation(root);
            }
            
            if(bf > 1 && balanceFactor(root.left) < 0){
                //here LR imbalance 
                //do LR roattion
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
            
            if(bf < -1 && balanceFactor(root.right) < 0){
                //do RR imbalance 
                //do lefttroattion 
                return leftRotation(root);
            }
            
            if(bf < -1 && balanceFactor(root.right) > 0){
                //here RL imbalance 
                //do LR roattion
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
            return root;
        }
        
        public int balanceFactor(Node root){
            if(root == null){
                return 0;
            }
            return (height(root.left) - height(root.right));
        }
        
        
        public int height(Node root){
            if(root == null){
                return 0;
            }
            return root.height;
        }
        
        public Node rightRotation(Node root){
            Node y = root.left;
            Node x = y.right;
            y.right = root;
            root.left = x;
            
            root.height = 1+ Math.max(height(root.left) , height(root.right));
            y.height = 1+ Math.max(height(root.left) , height(root.right));
            return y;
        }
        
        
        public Node leftRotation(Node root){
            Node y = root.right;
            Node x = y.left;
            y.left = root;
            root.right = x;
            
            root.height = 1+ Math.max(height(root.left) , height(root.right));
            y.height = 1+ Math.max(height(root.left) , height(root.right));
            
            return y;
        }
        
        public void inOrder(Node root){
            if(root == null){
                return ;
            }
            System.out.print(root.data + " ");
            inOrder(root.left);

            inOrder(root.right);
        }
        
        public Node delete(Node root , int delVal){
            
            if(root.data > delVal){
                root.left =  delete(root.left , delVal);
            }else if(root.data < delVal){
                root.right = delete(root.right , delVal);
            }else{
                if(root.left == null && root.right == null ){
                    return null;
                }else if(root.left == null){
                     return root.right;
                }else if(root.right == null){
                     return root.left;
                }else{
                
                Node Is = minNode(root.right);
                root.data = Is.data;
                root.right = delete(root.right , Is.data);
                }
            }        
                if(root == null){
                    return null;
                }
 
                root.height = 1+ Math.max(height(root.left) , height(root.right));
                
                return correction(root);
            
        }
        
        public Node minNode(Node root){
              while(root.left != null){
                  root = root.left;
              }
              return root;
        }
        
        public Node add(int node[] , Node root){
            for(int i : node){
                root = insert(root , i);
            }
            return root;
        }
    }
    public static void main(String[] args) {
        tree x = new tree();
        // x.root = x.insert(x.root , 5);
        // x.root = x.insert(x.root , 6);
        // x.root = x.insert(x.root , 9);
        // x.root = x.insert(x.root , 10);
        int node[] = {10 ,20 ,30 , 40 ,50 , 60 , 70, 80, 90};
        x.root = x.add(node ,x.root);
        
        x.inOrder(x.root);
        
        System.out.println();
        
        x.root = x.delete(x.root , 30);
                System.out.println();
        x.inOrder(x.root);
        
            //       6
            //     /   \  
            //   5      9
            //           \  
            //             10
    }
}