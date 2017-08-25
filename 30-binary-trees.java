import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
    static void levelOrder(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        boolean first = true;
        while(!stack.isEmpty()) {
            LinkedList<Node> stack2 = new LinkedList<>();
            while(!stack.isEmpty()) {
                Node curr = stack.removeLast();
                if (!first) System.out.print(" ");
                else first = false;
                System.out.print(curr.data);
                if (curr.left != null) stack2.push(curr.left);
                if (curr.right != null) stack2.push(curr.right);
            }
            stack = stack2;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }   
}