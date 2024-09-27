import java.util.Scanner;

class StackDemo {
    int top;
    int[] arr;
    int size;

    public StackDemo(int size) {
        this.top = -1;
        this.arr = new int[size];
        this.size = size;
    }

    public void push(int value) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = value;
        System.out.println(value + " pushed to stack");
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        top--;
        return arr[top + 1];
    }

    public void display() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Stack : ");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public int peep(int position) {
        // if(top < position-1 || position < 0){
        //     System.out.println("Invalid Position");
        //     return -1;
        // }
        // return arr[size-position];
        if (top - position + 1 < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top - position + 1];
    }

    public void change(int value, int position) {
        if (top - position + 1 < 0) {
            System.out.println("Stack Underflow");
            return;
        }
        arr[top - position + 1] = value;
    }
}

public class StackMethods {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Stack : ");
        int n = sc.nextInt();

        StackDemo stack = new StackDemo(n);

        int a = 0;

        while (a != 6) {
            System.out.println("Enter the Function You want to call : ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peep");
            System.out.println("5. Change");
            System.out.println("6. Exit");
            a = sc.nextInt();
            
            switch (a) {
                case 1:
                    System.out.println("Enter the Value you want to Push : ");
                    int v = sc.nextInt();
                    stack.push(v);
                    break;
                case 2:
                    System.out.println("Element : "+stack.pop());
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Enter the Position you want to See : ");
                    int p = sc.nextInt();
                    stack.peep(p);
                    break;
                case 5:
                    System.out.println("Enter the Position you want to Change : ");
                    int c = sc.nextInt();
                    System.out.println("Enter the value you want to assign : ");
                    int val = sc.nextInt(); 
                    stack.change(val, c);
                    break;
                case 6:
                    System.out.println("Exiting the Menu....");
                    break;
                
                default:
                    System.out.println("Invalid Function Call.... "); 
                    break;
            }

        }
        sc.close();
    }
}