class DQueue{
    int[] arr;
    int front;
    int rear;
    int size;

    public DQueue(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue_rear(int val){
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

    public int dequeue_first(){
        if (front < 0) {
            System.out.println("Queue Underflow...");
            return -1;
        }
        int temp = arr[front];
        front++;
        return temp;
    }

    public void equeue_front(int val){
        if (front == 0) {
            System.out.println("Overflow....");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else{
            front--;
        }
        arr[front] = val;
    }

    public int dequeue_rear(){
        if (rear < 0) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        int temp = arr[rear];

        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else{
            rear--;
        }
        return temp;
    }

    public void display(){
        System.out.println("==============================");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("=================================");
    }
}

public class DQueueDemo {
    public static void main(String[] args) {
        DQueue d = new DQueue(5);

        d.enqueue_rear(5);
        d.enqueue_rear(1);
        d.dequeue_rear();
        d.display();
    }
}
