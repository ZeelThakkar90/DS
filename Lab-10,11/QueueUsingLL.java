class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    QueueNode(int data,QueueNode next) {
        this.data = data;
        this.next = next;
    }
}

class Queue_LL {
    QueueNode front = null; 
    QueueNode rear = null;
    int size = 0;

    boolean empty() {
        return front == null;
    }

    int peek() {
        if (empty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else
            return front.data;
    }

    void enqueue(int value) {
        QueueNode temp = new QueueNode(value);
            if (front == null) {
                front = temp;
                rear = temp;
            } else {
                rear.next = temp;
                rear = temp;
            }
            System.out.println(value + " Inserted into Queue ");
            size++;
    }

    void dequeue() {
        if (front == null)
            System.out.println("Queue is Empty");
        else {
            System.out.println(front.data + " Removed From Queue");
            front = front.next;
            size--;
        }
    }
}

public class QueueUsingLL {
    public static void main(String args[])
    {
        Queue_LL Q = new Queue_LL();
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.enqueue(50);
        Q.dequeue();
        System.out.println("The size of the Queue is " + Q.size);
        System.out.println("The Peek element of the Queue is " + Q.peek());
    }
    
}