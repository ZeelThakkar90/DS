class Node{
    int data;
    Node next;
    Node back;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

class DLL{

    public Node head = null;

    public void convertArrToDLL(int[] arr){
        head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.back = prev;
            prev.next = temp;
            prev = prev.next;
        }
    }

    public void display(){
        System.out.println("=================================");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("=================================");
    }

    public void deleteFirst(){
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;
    }

    public void deleteLast(){
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        Node newTail = current.back;
        newTail.next = null;
        current.back = null;
    }

    public void deleteKth(int k){
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;

            if (count == k) {
                break;
            }
            current = current.next;
        }
        Node prev = current.back;
        Node front = current.next;

        if (prev == null && front == null) {
            head = null;
            return;
        }
        else if (prev == null) {
            deleteFirst();
        }
        else if(front == null){
            deleteLast();
        }
        else{
            front.back = prev;
            prev.next = front;
            current.next = null;
            current.back = null;
        }
    }

    public void deleteValue(int val){
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == val) {
                break;
            }
            current = current.next;
        }
        Node prev = current.back;
        Node front = current.next;

        if (prev == null && front == null) {
            head = null;
            return;
        }
        else if (prev == null) {
            deleteFirst();
        }
        else if(front == null){
            deleteLast();
        }
        else{
            front.back = prev;
            prev.next = front;
            current.next = null;
            current.back = null;
        }
    }

    public void deleteNode(Node temp){
        //temp should not be head because if it is head then we have to make new head
        Node prev = temp.back;
        Node front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.back = null;
            return;
        }

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;
    }

    public void insertBeforeHead(int val){
        Node newHead = new Node(val);
        if (head == null) {
            head = newHead;
            return;
        }
        newHead.next = head;
        newHead.back = null;
        head.back = newHead;
        head = newHead;
    }

    public void insertBeforeTail(int val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        
        if (head.next == null) {
            insertBeforeHead(val);
            return;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back; 

        newNode.next = tail;
        newNode.back = prev;

        prev.next = newNode;
        tail.back = newNode;
    }
    
    public void insertBeforeK(int k,int val){
        if (k == 1) {
            insertBeforeHead(val);
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;

            if (count == k) {
                break;
            }
            current = current.next;
        }
        Node prev = current.back;

        Node newNode = new Node(val);
        newNode.next = current;
        newNode.back = prev;

        prev.next = newNode;
        current.back = newNode;
    }

    public void insertBeforeValue(int val,int newNodeValue){
        if (head.data == val) {
            insertBeforeHead(newNodeValue);
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == val) {
                break;
            }
            current = current.next;
        }
        Node prev = current.back;

        Node newNode = new Node(newNodeValue);
        newNode.next = current;
        newNode.back = prev;

        prev.next = newNode;
        current.back = newNode;
    }

    public void insertBeforeNode(Node temp,int val){
        //temp cant be head
        Node prev = temp.back;
        Node newNode = new Node(val);
        newNode.next = temp;
        newNode.back = prev;

        prev.next = newNode;
        temp.back = newNode;
    }

    public void deleteAlternate(){
        Node current = head;
        int count = 0;
        
        while (current != null ) {
            count++;

            if (count % 2 == 0) {
                Node prev = current.back;
                Node front = current.next;

                prev.next = front;
                front.back = prev;
                current.next = null;
                current.back = null;

                current = front;
            }
            else{
                current = current.next;
            }
        }
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        DLL dll = new DLL();
        dll.convertArrToDLL(arr);
        dll.insertBeforeK(7,9);
        dll.display();
    }
}
