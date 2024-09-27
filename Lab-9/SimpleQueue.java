import java.util.Scanner;

class QueueDemo{
    int[] arr;
    int front;
    int rear;
    int size;

    public QueueDemo(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int val){
        if (rear >= size-1) {
            System.out.println("Queue Overflow...");
            return;
        }
        rear++;
        arr[rear] = val;
        if (front == -1) {
            front = 0;
        }
    }

    public int dequeue(){
        if (front < 0) {
            System.out.println("Queue Underflow...");
            return -1;
        }
        int temp = arr[front];
        front++;
        return temp;
    }

    public void display(){
        System.out.println("=======================================");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("=========================================");
    }
}


public class SimpleQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of the Queue");
        int n = sc.nextInt();

        QueueDemo q = new QueueDemo(n);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Element :");
            q.enqueue(sc.nextInt());
        }
        q.dequeue();
        q.display();
        sc.close();
    }
}
