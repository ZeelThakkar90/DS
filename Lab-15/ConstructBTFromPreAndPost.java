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

public class ConstructBTFromPreAndPost {

    static int i , j;
    public static void main(String[] args) {
        int[] preOrder = {1,2,3,4,5,6};
        int[] postOrder = {3,4,2,6,5,1};

        i = 0;
        j = 0;
        
        Node root = constructTree(preOrder, postOrder);
        preOrder(root);
    }

    public static Node constructTree(int[] preOrder, int[] postOrder){
        Node root = new Node(preOrder[i]);

        i++;
        if (postOrder[j] != root.data) {
            root.left = constructTree(preOrder, postOrder);
        }
        if (postOrder[j] != root.data) {
            root.right = constructTree(preOrder, postOrder);
        }


        j++;
        return root;
    }

    public static void preOrder(Node root){
        if (root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
