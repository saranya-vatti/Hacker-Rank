package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Node {
    public int left;
    public int right;
    public Node leftChild;
    public Node rightChild;
    public Node parent;
    public boolean isLeaf;
    Node(int left, int right, Node parent) {
        if(right<left) {
            return;
        }
        if(left<0) {
            if(right<0) {
                return;
            } else {
                left = right;
            }
        }
        if(right<0) {
            right = left;
        }
        this.left = left;
        this.right  =right;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = parent;
        this.isLeaf = true;
    }

    @Override
    public String toString() {
        return "[" + this.left + ", " + this.right + "]";
    }
}
class IntervalTree {
    Node root;
    public int sum(int a, int b) {
        if(a==b) return a;
        if(b==a+1) return a+b;
        return ((b-a+1)*(a+b))/2;
    }
    public int taken(Node head, int start, int end, Node parent, boolean isLeftChild) {
        if(head==null || start >head.right || end < head.left) return 0;
        Node curr = head;
        if(head.isLeaf) {
            if(curr.left < start && end < curr.right) {
                curr.leftChild = new Node(curr.left, start - 2, curr);
                curr.rightChild = new Node(end + 2, curr.right, curr);
                if(curr.leftChild == null) {
                    if(curr.rightChild == null) {
                        curr.isLeaf = true;
                    }
                } else {
                    curr.isLeaf = false;
                }
                if(parent!=null) {
                    if(isLeftChild) {
                        parent.leftChild = curr;
                    } else {
                        parent.rightChild = curr;
                    }
                }
                int answer = sum(start-1, end+1);
                return answer;
            } else if(curr.left < start && start <= curr.right && curr.right <= end) {
                int answer = sum(start-1, curr.right);
                curr = new Node(curr.left, start - 2, curr);
                if(parent!=null) {
                    if(isLeftChild) {
                        parent.leftChild = curr;
                    } else {
                        parent.rightChild = curr;
                    }
                }
                curr.parent = parent;
                return answer;
            } else if(start<=curr.left && curr.left <= end && end < curr.right) {
                int answer = sum(curr.left, end+1);
                curr = new Node(end+2, curr.right, curr);
                if(parent!=null) {
                    if(isLeftChild) {
                        parent.leftChild = curr;
                    } else {
                        parent.rightChild = curr;
                    }
                }
                return answer;
            } else if((start<curr.left && curr.left<=curr.right && curr.right<end) || (start==curr.left && end==curr.right)) {
                if(isLeftChild && parent!=null) {
                    parent.leftChild=null;
                }
                if(parent!=null && parent.leftChild==null && parent.rightChild==null) {
                    parent.isLeaf = true;
                }
                return sum(curr.left, curr.right);
            }
            return 0;
        }
        return taken(head.leftChild, start,end, head, true) + taken(head.rightChild,start,end, head, false);
    }
    IntervalTree(int start, int end) {
        this.root = new Node(start, end, null);
    }

    public String toString(Node node) {
        if(node == null) return "";
        String str = "Node : " + node.toString();
        if(node.leftChild!=null) str = str + "\nLeft Child : " + toString(node.leftChild);
        if(node.rightChild!=null) str = str + "\nRight Child : " + toString(node.rightChild);
        return str;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int lastIndex = 0;
        IntervalTree tree = new IntervalTree(0, n-1);
        for(int a0 = 0; a0 < s; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(tree.taken(tree.root, l, r, null, false));
        }
        in.close();
    }
}
