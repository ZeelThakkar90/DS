class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class SwapConsecutive {
    public static void main(String[] args) {
        
    }

    public static void addOne(Node head){
        LL newList = new LL();
        newList.head = head;
        newList.reverseLL();

        Node tNode = head;
        int carry = 1;

        while (tNode != null) {
            tNode.data += carry;
            if (tNode.data < 10) {
                carry = 0;
                break;
            }
            else{
                carry = 1;
                tNode.data = 0;
            }
            tNode = tNode.next;
        }
    }
    
}
