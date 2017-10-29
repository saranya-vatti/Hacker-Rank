
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Node {
    public BigInteger left;
    public BigInteger right;
    Node(BigInteger left, BigInteger right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + this.left + ", " + this.right + "]";
    }
}
public class Solution {
    private static int globalIndex=-1;
    private static ArrayList<Node> alist = new ArrayList<>();

    private static BigInteger sum(BigInteger a, BigInteger b) {
        if(a.equals(b)) return a;
        if(b.equals(a.add(new BigInteger("1")))) return a.add(b);
        return ((b.subtract(a).add(new BigInteger("1"))).multiply(a.add(b))).divide(new BigInteger("2"));
    }

    private static Node search(BigInteger l, BigInteger r, int start, int end) {
        Node startNode = alist.get(start);
        if(start >= end) {
            globalIndex = start;
            return startNode;
        }
        Node endNode = alist.get(end);
        int mid = (start+end)/2;
        Node midNode = alist.get(mid);
        if(startNode.left.compareTo(l)<=0 && r.compareTo(startNode.right)<=0) {
            globalIndex = start;
            return startNode;
        }
        if(endNode.left.compareTo(l)<=0 && r.compareTo(endNode.right)<=0) {
            globalIndex = end;
            return endNode;
        }
        if(l.compareTo(midNode.left)<=0) {
            return search(l, r, start+1, mid);
        }
        return search(l, r, mid, end-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        int s = in.nextInt();
        Node head = new Node(BigInteger.ZERO, n.subtract(BigInteger.ONE));
        alist.add(head);
        for(int a0 = 0; a0 < s; a0++){
            BigInteger l = in.nextBigInteger();
            BigInteger r = in.nextBigInteger();
            BigInteger ans=sum(l, r);
//            System.out.println(Arrays.toString(alist.toArray()));
            Node curr = search(l, r, 0, alist.size()-1);
            int currIndex = globalIndex;
            BigInteger lMinusOne = l.subtract(BigInteger.ONE);
            BigInteger lMinusTwo = lMinusOne.subtract(BigInteger.ONE);
            BigInteger rPlusOne = r.add(BigInteger.ONE);
            BigInteger rPlusTwo = rPlusOne.add(BigInteger.ONE);
            Node leftNode = null;
            Node rightNode = null;
            if(currIndex-1 >= 0 && currIndex-1 <= alist.size()-1) leftNode = alist.get(currIndex-1);
            if(currIndex+1 >= 0 && currIndex+1 <= alist.size()-1) rightNode = alist.get(currIndex+1);
            if(curr.left.equals(l)) {
                if(leftNode != null) {
                    ans = ans.add(leftNode.right);
                    if(leftNode.left.equals(leftNode.right)) {
                        alist.remove(currIndex-1);
                        currIndex--;
                    } else {
                        leftNode.right = leftNode.right.subtract(BigInteger.ONE);
                    }
                }
                curr.left = rPlusTwo;
            } else {
                if(curr.left.equals(lMinusOne)) {
                    curr.left=rPlusTwo;
                }
                ans = ans.add(lMinusOne);
            }
            if(curr.right.equals(r)) {
                if(rightNode != null) {
                    ans = ans.add(rightNode.left);
                    if(rightNode.left.equals(rightNode.right)) {
                        alist.remove(currIndex+1);
                    } else {
                        rightNode.left = rightNode.left.add(BigInteger.ONE);
                    }
                }
                curr.right=lMinusTwo;
            } else  {
                if(curr.right.equals(rPlusOne)) {
                    curr.right = lMinusTwo;
                }
                ans = ans.add(rPlusOne);
            }
            if(curr.left.compareTo(curr.right)>0) {
                alist.remove(currIndex);
                currIndex--;
            }
            if(curr.left.compareTo(lMinusOne)<0 && rPlusOne.compareTo(curr.right)<0) {
                alist.add(currIndex+1, new Node(rPlusTwo, curr.right));
                curr.right = lMinusTwo;
            }
            System.out.println(ans);
        }
        in.close();
    }
}
