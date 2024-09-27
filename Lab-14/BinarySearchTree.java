class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BST{
    
    public Node root = null;
    
    public void preOrder(Node root){
        if (root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
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

    public void insertArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            root = insertRecursive(root, arr[i]);
        }
    }

    public Node insertRecursive(Node root , int val){
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insertRecursive(root.left, val);
        }
        else if (val > root.data) {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }

    public void insertIterative(int val){
        if(root == null){
            root = new Node(val);
            return;
        }
        Node curr = root;
        while (true) {
            if (curr.data == val) {
                return;
            }

            if (val < curr.data) {
                if (curr.left == null) {
                    curr.left = new Node(val);
                    return;
                }
                curr = curr.left;
            }
            else{
                if (curr.right == null) {
                    curr.right = new Node(val);
                    return;
                }
                curr = curr.right;
            }
        }
    }

    public void insertArrIterative(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insertIterative(arr[i]);
        }
    }


    public boolean search(Node root,int val){
        if (root == null) {
            return false;
        }
        else if (root.data == val) {
            return true;
        }
        else if (val > root.data) {
            return search(root.right,val);
        }
        else{
            return search(root.left, val);
        }
    }

    public boolean searchIterative(int val){
        if (root == null) {
            return false;
        }

        Node curr = root;
        while (true) {
            if (curr.data == val) {
                return true;
            }

            if (val < curr.data) {
                if (curr.left != null) {
                    curr = curr.left;
                }
                else{
                    break;
                }
            }

            if (val > curr.data) {
                if (curr.right != null) {
                    curr = curr.right;
                }
                else{
                    break;
                }
            }
        }
        return false;
    }

    public Node deleteNode(Node root, int key) {
        if(root == null) return null;

        if(root.data == key) return helper(root);

        Node dummy = root;
        while(root != null){
            if(root.data > key){
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public Node helper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            // TreeNode rightChild = root.right;
            // TreeNode lastRight = findLastRight(root.left);
            // lastRight.right = rightChild;
            // return root.left;

            Node leftChild = root.left;
            Node lastLeft = findLastLeft(root.right);
            lastLeft.left = leftChild;
            return root.right;
        }
    }

    public Node findLastRight(Node root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }

    public Node findLastLeft(Node root){
        if(root.left == null){
            return root;
        }
        return findLastLeft(root.left);
    }

    public boolean isSame(Node p , Node q){
        if (p == null || q == null) {
            return (p == q);
        }
        return (p.data == q.data) && isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return (n1 == n2);
        }
        
        return n1.data == n2.data && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }

    public int smallest(Node root){
        Node curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    public int highest(Node root){
        Node curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = {3,0,1,2,5,4,6};
        bst.insertArrIterative(arr);

        // System.out.println(bst.searchIterative(0));

        // bst.deleteNode(bst.root, 5);
        // bst.inOrder(bst.root);

        System.out.println(bst.highest(bst.root));
    }
}
