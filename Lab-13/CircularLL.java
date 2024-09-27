import java.util.Scanner;

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

class CLL{
    Node head = null;
    Node tail = null;

    public void convertArrToCLL(int[] arr){
        head = new Node(arr[0]);
        Node move = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            move.next = temp;
            move = move.next;
        }
        tail = move;
        tail.next = head;
    }

    public void display(){
        System.out.println("==========================================");
        Node move = head;
        while (move != tail) {
            System.out.print(move.data+" ");
            move = move.next;
        }
        System.out.println(move.data);
        System.out.println("==========================================");
    }

    public void insertAtFirst(int val){
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            tail = temp;
            head.next = head;
            return;
        }
        temp.next = head;
        tail.next = temp;
        head = temp;
    }

    public void insertAtLast(int val){
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            tail = temp;
            head.next = head;
            return;
        }
        tail.next = temp;
        temp.next = head;
        tail = temp;
    }

    public void insertInOrdered(int val){
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            tail = temp;
            head.next = head;
            return;
        }
        if (val <= head.data) {
            temp.next = head;
            tail.next = temp;
            head = temp;
            return;
        }
        Node move = head;
        while (move != tail && temp.data>=move.next.data) {
            move = move.next;
        }
        temp.next = move.next;
        move.next = temp;
        if (move == tail) {
            tail = temp;
        }
    }

    public void deleteElementByValue(int val){
        if(head.data == val){
            tail.next = head.next;
			head = head.next;
			System.out.println("Deleted Successfully");
			return;
		}

        Node temp=head;

		while(temp.next!=head){
			if(temp.next.data == val){
                if(temp.next == tail){
                    tail = temp;
                }
				temp.next = (temp.next).next;
				System.out.println("Deleted Successfully");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Data Not Found");
		return;
	}

    public int getSize(Node head){
        Node temp=head;
		int count=0;
		if(temp==null){
			return 0;
		}
		do{
			count++;
			temp=temp.next;
		}while(temp!=head);
		return count;
    }

    public void deleteKth(int k){
        if(k == 1){
            tail.next = head.next;
			head = head.next;
			System.out.println("Deleted Successfully");
			return;
		}

        Node temp = head;
        Node prev = null;
        int count = 0;

		while(temp != tail){
            count++;
			if(count == k){
				prev.next = (prev.next).next;
				System.out.println("Deleted Successfully");
				return;
			}
            prev = temp;
			temp = temp.next;
		}

        if(k == getSize(head)){
            prev.next = null;
            tail = prev;
            return;
        }

		System.out.println("Position Not Found");
		return;
	}

    public static void displayForSplit(Node temphead, Node temptail){
        System.out.println("==========================================");
        Node move = temphead;
        while (move != temptail) {
            System.out.print(move.data+" ");
            move = move.next;
        }
        System.out.println(move.data);
        System.out.println("==========================================");
    }

    public void splitCLL(){
        Node slow = head;
        Node fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("jed");
        }

        //check if cll have even nodes
        if (fast.next.next == head) {
            fast = fast.next;
        }

        System.out.println(slow.data);
        Node middle = slow;
        Node newHead = middle.next;
        middle.next = head;

        
        fast.next = newHead;
        System.out.println("Linked List 1 :");
        displayForSplit(head,middle);
        System.out.println("Linked List 2 :");
        displayForSplit(newHead,fast);
    }
}

public class CircularLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Circular Linked List : ");
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element in Array:");
            arr[i] = sc.nextInt();
        }
        CLL cll = new CLL();
        cll.convertArrToCLL(arr);
        // System.out.println(cll.getSize(cll.head));
        cll.splitCLL();
        // cll.display();
        sc.close();
    }
}
