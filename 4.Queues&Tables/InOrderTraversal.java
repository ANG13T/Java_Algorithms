public class Starter{

    private class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

 private class BinaryTree{
    Node root;

    public BinaryTree(){
        root = null;
    }

    void printInOrderN(Node n){
        if(n == null){
            return;
        }

        printInOrderN(n.left);
        System.out.println(n.data);
        printInOrderN(n.right);
    }

     public void printInorder()    {     printInOrderN(root);   } 
}

    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 

        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 

    } 
}

