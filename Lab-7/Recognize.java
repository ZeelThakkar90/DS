
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

public class Recognize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.nextLine();
        sc.close();
        
        StackDemo s = new StackDemo(str.length());
        s.push('c');
        int i = 0;
        while (str.charAt(i) != 'c') {
            if (str.charAt(i) == ' ') {
                System.out.println("Invalid String");
                return;
            }
            s.push(str.charAt(i));
            i++;
        }
        i++;
        for (int j = i; j < str.length(); j++) {
            if (str.charAt(j) != s.pop()) {
                System.out.println("Invalid String");
                return;
            }
            
        }
        if (s.pop() == 'c') {
            System.out.println("Valid String");
        }

    }
}