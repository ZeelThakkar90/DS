class Feather{
    String[] arr;
    int front;
    int rear;
    int size;

    public Feather(int size){
        this.size = size;
        arr = new String[size];
        front = -1;
        rear = -1;
    }

    String[] a;

    public void splitString(String str){
        a = str.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (a[i].startsWith("buy")) {
                a[i] = a[i].replace("buy_", "");
            }
            // System.out.println(a[i]);
        }
        callOtherFunction();
    }

    public void buy(String s){
        if (rear + 1 == front || (rear >= size-1 && front == -1)) {
            System.out.println("Oops..!! Feather Has No Space Left!!");
            return;
        }
        rear = (rear+1)%size;
        arr[rear] = s;
        if (front == -1) {
            front = 0;
        }
    }

    public String deleteFront(){
        if (front < 0) {
            System.out.println("Oops..!! Feather is Empty!!");
            return "";
        }
        String temp = arr[front];
        if (front == rear) {
            //only one element in queue
            front = -1;
            rear = -1;
        }
        front = (front +1)%size;
        return temp;
    }

    public void fetch(){
        String temp = deleteFront();
        buy(temp);
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

    public void callOtherFunction(){
        for (int i = 0; i < a.length; i++) {
            if (a[i].equalsIgnoreCase("fetch")) {
                fetch();
            }
            else{
                buy(a[i]);
            }
        }
        display();
    }
}

public class PercyThePeacock {
    public static void main(String[] args) {
        String str = "buy_red buy_blue buy_green fetch fetch buy_yellow fetch fetch fetch fetch";
        
        Feather f = new Feather(10);

        f.splitString(str);
    }
}
