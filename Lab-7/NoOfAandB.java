
import java.util.Scanner;

class StackDemo{
    char[] str;
    int size;
    int top;

    public StackDemo(int size){
        this.size = size;
        str = new char[size];
        top = -1;
    }

    public void push(char value) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        str[top] = value;
    }

    public char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return '0';
        }
        top--;
        return str[top + 1];
    }
}


public class NoOfAandB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String str = sc.nextLine();
        sc.close();

        StackDemo s = new StackDemo(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'a' && str.charAt(i) != 'b') {
                System.out.println("Invalid String");
                return;
            }
            s.push(str.charAt(i));
        }

        int count_a = 0;
        int count_b = 0;

        for (int i = s.top; i >= 0; i--) {
            switch (s.pop()) {
                case 'a':
                    count_a++;
                    break;
                case 'b':
                    count_b++;
                    break;
            
                default:
                    System.out.println("Invalid String");
                    break;
            }
        }
        if (count_a == count_b && count_a >= 1) {
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
        }
    }
}
