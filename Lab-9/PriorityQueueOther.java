class PriorityQueueImplimentation{
    int [][] a;
    int front = -1;
    int rear = -1;
    public PriorityQueueImplimentation(int size){
        a = new int[size][2];
    }

    public void insert(int data,int p){

        if(rear>=a.length-1){
            System.out.println("overflow");
            return;
        }
        if(front==-1){
            a[0][0] = data;
            a[0][1] = p;
            front = 0;
            rear = 0;
            return;
        }

        for(int i=front;i<=rear;i++){
            if(a[i][1]<p){
                for(int j = rear+1;j>i;j--){
                    a[j][0] = a[j-1][0];
                    a[j][1] = a[j-1][1];
                }
                // int temp = a[i][0];
                // int tempp = a[i][1];

                a[i][0] = data;
                a[i][1] = p;


                rear = rear + 1;
                return;
            }
        }
        
        rear = rear +1;
        a[rear][0] = data;
        a[rear][1] = p;
        return;
        
    }

    public int delete(){
        int data;

        if(front==rear){
            data = a[front][0];
            front = -1;
            rear = -1;
            return data;
        }
        else{
            data = a[front][0];
            front++;
            return data;
        }

    }

    public void display(){
        System.out.println("=============================");
        for(int i=front;i<=rear;i++){
            System.out.print(a[i][0]+" ");
        }
        System.out.println();
        System.out.println("=============================");
    }

}

public class PriorityQueueOther {
    public static void main(String[] args) {
        
        PriorityQueueImplimentation p = new PriorityQueueImplimentation(5);

        p.insert(1, 2);
        p.insert(2, 1);
        p.insert(3, 2);
        p.insert(5, 1);
        p.insert(8, 5);
        p.delete();
        p.display();
    }
}