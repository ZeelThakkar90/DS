import java.util.*;
import java.util.LinkedList;

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

class BT{
    public Node root = null;

    public void preOrder(Node node){
        //node which is given must be root node of the BT
        if (node == null) {
            return;
        }

        //root left right
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        //node which is given must be root node of the BT
        if (node == null) {
            return;
        }

        //left root right
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    public void postOrder(Node node){
        //node which is given must be root node of the BT
        if (node == null) {
            return;
        }

        //left right node
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    public Node arrToBTRecursive(int[] arr,int index){
        if (index >= arr.length ) {
            return null;
        }
        Node temp = new Node(arr[index]);
        temp.left = arrToBTRecursive(arr, index*2+1);
        temp.right = arrToBTRecursive(arr, index*2+2);
        return temp;
    }

    public void arrToBTQueue(int[] arr){
        Queue<Node> q = new LinkedList<Node>();
        root = new Node(arr[0]);
        q.offer(root);

        int i = 1;
        while (i<arr.length) {
            Node newNode = q.poll();

            newNode.left = new Node(arr[i]);
            i++;
            newNode.right = new Node(arr[i]);
            i++;

            q.add(newNode.left);
            q.add(newNode.right);
        }
    }

    public void leafNodes(Node root){
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data+" ");
            return;
        }
        leafNodes(root.left);
        leafNodes(root.right);
    }

    public void leafNodesIteratrive(Node root){
        if (root == null)
            return;

        // implement iterative preorder traversal and start
        // storing leaf nodes.
        Stack<Node> st = new Stack<>();
        st.push(root);
 
        while (!st.isEmpty()) {
            root = st.peek();
            st.pop();
 
            // if node is leafnode, print its data
            if (root.left == null && root.right == null)
                System.out.print(root.data + " ");
 
            if (root.right != null)
                st.push(root.right);
            if (root.left != null)
                st.push(root.left);
        }
    }

    public int countLeafNodes(Node root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public void countLeafNodesIteratrive(Node root){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        int count = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left == null && temp.right == null){
                count++;
            }
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        System.out.println("No of Leaf Nodes : "+count);
    }

    public void insertNode(int val){
        Queue<Node> q = new LinkedList<Node>();
        if (root == null) {
            root = new Node(val);
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left == null) {
                curr.left = new Node(val);
                break;
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right == null) {
                curr.right = new Node(val);
                break;
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        BT bt = new BT();
        int[] arr = {1,2,3,4,5,6,7};
        // bt.root = bt.arrToBTRecursive(arr,0);
        bt.arrToBTQueue(arr);
        bt.inOrder(bt.root);

        // bt.leafNodesIteratrive(bt.root);
        System.out.println();
        // bt.countLeafNodesIteratrive(bt.root);
        bt.insertNode(8);
        bt.inOrder(bt.root);
    }
}
