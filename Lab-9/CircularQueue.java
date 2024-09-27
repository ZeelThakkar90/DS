import java.util.Scanner;

class CircularQueueDemo{
    int[] arr;
    int front;
    int rear;
    int size;

    public CircularQueueDemo(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue_other(int val){
        if (rear == size) {
            rear = 0;
        }
        else{
            rear++;
        }

        if (front == rear) {
            System.out.println("Overflow...");
            return;
        }
        arr[rear] = val;

        if (front == -1) {
            front = 0;
        }
    }

    public void enqueue(int val){
        if (rear + 1 == front || (rear >= size-1 && front == -1)) {
            System.out.println("Circular Queue Overflow....");
            return;
        }
        rear = (rear+1)%size;
        arr[rear] = val;
        if (front == -1) {
            front = 0;
        }
    }

    public int dequeue(){
        if (front < 0) {
            System.out.println("Underflow....");
            return -1;
        }
        int temp = arr[front];
        if (front == rear) {
            //only one element in queue
            front = -1;
            rear = -1;
        }
        front = (front +1)%size;
        return temp;
    }

    public void display(){
        System.out.println("=======================================");
        for (int i = front; ;i=(i+1)%size) {
            System.out.print(arr[i]+" ");
            if(i==rear) break;
        }
        System.out.println();
        System.out.println("=========================================");
    }
}


public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of the Circular Queue");
        int n = sc.nextInt();

        CircularQueueDemo cq = new CircularQueueDemo(n);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Element :");
            cq.enqueue_other(sc.nextInt());
        }
        System.out.println(cq.dequeue());
        cq.enqueue(10);
        System.out.println(cq.dequeue());
        sc.close();
    }
}