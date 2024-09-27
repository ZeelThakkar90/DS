import java.util.Scanner;
import java.util.Stack;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class LL {

    Node head = null;

    public void convertArrToLL(int[] arr) {
        head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
    }

    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void display() {
        System.out.println("==========================================");
        Node move = head;
        while (move != null) {
            System.out.print(move.data + " ");
            move = move.next;
        }
        System.out.println();
        System.out.println("==========================================");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }

        Node move = head;

        while (move.next != null) {
            move = move.next;
        }
        move.next = newNode;
    }

    public void deleteFirst() {
        if (head == null || head.next == null) {
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null || head.next == null) {
            return;
        }
        Node move = head;
        while (move.next.next != null) {
            move = move.next;
        }
        move.next = null;
    }

    public void deleteAtPosition(int position) {
        // if (head == null || position == 0) {
        // return ;
        // }
        // Node prev = head;
        // int count = 1;
        // while (count != position - 1) {
        // prev = prev.next;
        // count++;
        // }
        // prev.next = prev.next.next;

        if (head == null || position == 0) {
            return;
        }

        if (position == 1) {
            head = head.next;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            count++;
            if (count == position) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == value) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void swap(Node head){
        Node curr = head;
        // Node prev = null;
        while (curr.next.next != null) {
            Node front = curr.next;
            front.next = curr;
            // prev = curr;
            curr = curr.next.next;
            front.next.next = curr.next;
            System.out.println("Swapp");
        }
    }

    public int getLength() {
        int count = 0;
        if (head == null) {
            System.out.println("Length of Linked List is : " + count);
            return count;
        }
        Node move = head;
        while (move != null) {
            count++;
            move = move.next;
        }
        return count;
    }

    public void reverseLL() {
        // Node temp = head;
        // Stack<Integer> st = new Stack<>();
        // while (temp != null) {
        //     st.push(temp.data);
        //     temp = temp.next;
        // }
        // temp = head;
        // while (temp != null) {
        //     temp.data = st.pop();
        //     temp = temp.next;
        // }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        head = prev;
    }

    public void removeDuplicatesInSorted() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void removeDuplicatesInUnsorted() {
        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp.next != null) {
                if (curr.data == temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
    }

    public boolean isSame(LL list1 , LL list2) {

        if (list1.getLength() != list2.getLength()) {
            return false;
        }
        Node move1 = list1.head;
        Node move2 = list2.head;
        while (move1!= null && move2!= null) {
            if (move1.data != move2.data)  {
                return false;
            }
            move1 = move1.next;
            move2 = move2.next;
        }
        return true;
    }

    public LL copyLL(LL list1) {
        LL list2 = new LL();
        list2.head = new Node(list1.head.data);
        Node move1 = list1.head.next;
        Node move2 = list2.head;
        while (move1 != null) {
            Node temp = new Node(move1.data);
            move2.next = temp;
            move1 = move1.next;
            move2 = move2.next;
        }
        return list2;
    }

    public void insertInOrderedLL(int val){
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        }
        if (val<head.data) {
            temp.next = head;
            head = temp;
        }
        Node move = head;
        while (move != null && move.next.data<=val) {
            move = move.next;
        }
        temp.next = move.next;
        move.next = temp;
    }

    public void sortLL(){
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }
        Node move = head;
        while (move.next != null) {
            Node temp = move.next;
            while (temp != null) {
                if (move.data > move.data) {
                    int t = move.data;
                    move.data = temp.data;
                    temp.data = t;
                }
                temp = temp.next;
            }
            move = move.next;
        }
    }

    public boolean isPalindrom(){
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != st.pop()) {
                return false;
            }
        }
        return true;
    }

    public void gcdAddBetweenNode() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }

        Node move = head;

        while (move.next != null) {
            Node temp = new Node(gcd(move.data, move.next.data));

            temp.next = move.next;
            move.next = temp;
            move = move.next.next;
        }
        System.out.println("Gcd Added Successfully");
    }

    public static int gcd(int a , int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        } else {
            return a;
        }
    }
    
}

public class LinkedListDemo {
    public static void main(String[] args) {
        // Node n = new Node(5);
        // System.out.println(n.data);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter Size of the linked list : ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter Elements of the linked list : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element : ");
            arr[i] = sc.nextInt();
        }

        LL newlist = new LL();
        newlist.convertArrToLL(arr);

        // newlist.swap(newlist.head);
        // newlist.gcdAddBetweenNode();
        // newlist.display();

        int f = 0;

        while (f != 16) {
            System.out.println("Enter Function You want to Select : ");
            System.out.println("1. Insert a node at the front of the linked list : ");
            System.out.println("2. Display all nodes : ");
            System.out.println("3. Delete a first node of the linked list");
            System.out.println("4. Insert a node at the end of the linked list");
            System.out.println("5. Delete a last node of the linked list");
            System.out.println("6. Delete a node from specified position");
            System.out.println("7. Delete a node from specified value");
            System.out.println("8. Get Length of Linked List");
            System.out.println("9. Reverse Linked List");
            System.out.println("10. Remove Duplicates from Sorted Linked List");
            System.out.println("11. Remove Duplicates from Unsorted Linked List");
            System.out.println("12. Check if two linked lists are same");
            System.out.println("13. Copy Linked List");
            System.out.println("14. Insert Node in Ordered Linked List");
            System.out.println("15. Insert Node in Ordered Linked List");
            System.out.println("16. Exit");
            f = sc.nextInt();

            switch (f) {
                case 1:
                    System.out.println("Enter value to insert at front : ");
                    int value = sc.nextInt();
                    newlist.addAtFirst(value);
                    System.out.println("Value Inserted Successfully");
                    break;
                case 2:
                    System.out.println("Displaying Linked List : ");
                    newlist.display();
                    break;
                case 3:
                    newlist.deleteFirst();
                    System.out.println("First node deleted successfully");
                    break;
                case 4:
                    System.out.println("Enter value to insert at end : ");
                    int val = sc.nextInt();
                    newlist.insertAtEnd(val);
                    System.out.println("Value Inserted Successfully");
                    break;
                case 5:
                    newlist.deleteLast();
                    System.out.println("Last node deleted successfully");
                    break;
                case 6:
                    System.out.println("Enter position to delete node : ");
                    int pos = sc.nextInt();
                    newlist.deleteAtPosition(pos);
                    System.out.println("Node deleted successfully at position " + pos);
                    break;
                case 7:
                    System.out.println("Enter value to delete node : ");
                    int v = sc.nextInt();
                    newlist.deleteByValue(v);
                    System.out.println("Node deleted successfully ");
                    break;
                case 8:
                    System.out.println("Length of the Given Linked List is : "+newlist.getLength()); 
                    break;
                case 9:
                    newlist.reverseLL();
                    System.out.println("Linked List Reversed Successfully");
                    break;
                case 10:
                    newlist.removeDuplicatesInSorted();
                    System.out.println("Duplicates Removed Successfully");
                    break;
                case 11:
                    newlist.removeDuplicatesInUnsorted();
                    System.out.println("Duplicates Removed Successfully");
                    break;
                case 12:
                    int[] arr1 = {1, 2, 3, 4, 5};
                    int[] arr2 = {1, 2, 3, 5};
                    LL list1 = new LL();
                    list1.convertArrToLL(arr1);
                    LL list2 = new LL();
                    list2.convertArrToLL(arr2);
                    boolean same = list1.isSame(list1, list2);
                    if (same) {
                        System.out.println("Given Linked Lists are Same");
                    }
                    else{
                        System.out.println("Given Linked Lists are Not Same");
                    }
                    break;
                case 13:
                    LL newLL = newlist.copyLL(newlist);
                    newLL.display();
                case 14:
                    System.out.println("Enter the Value You Want to insert in Ordered Linked List:");
                    int a = sc.nextInt();
                    newlist.insertInOrderedLL(a);
                    System.out.println("Node Inserted Successfully....");
                    break;
                case 15:
                    newlist.sortLL();
                    System.out.println("Linked List Sorted Successfully....");
                    break;
                case 16:
                    System.out.println("Exiting... Goodbye! ^^");
                    return;
                default:
                    System.out.println("Invalid Option. Please try again. ^^");
                    break;
            }
        }
        sc.close();

    }
}