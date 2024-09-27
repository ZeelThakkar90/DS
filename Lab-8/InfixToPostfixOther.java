import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixOther {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix :");
        String inf = sc.next();
        sc.close();
        inf += ')';

        Stack<Character> st = new Stack<>();
        st.push('(');
        String postfix = "";
        int rank = 0;
        int top = st.size();

        for (int i = 0; i < inf.length(); i++) {
            if (top < 0) {
                System.out.println("Invalid String");
                return;
            }
            
            while (stackPrior(st.peek()) > inputPrior(inf.charAt(i))) {
                char temp = st.pop();
                postfix += temp;
                rank += getRank(temp);

                if (rank < 0) {
                    System.out.println("rank");
                    System.out.println("Invalid");
                    return;
                }
            }

            if (stackPrior(st.peek()) != inputPrior(inf.charAt(i))) {
                st.push(inf.charAt(i));
            }
            else{
                st.pop();
            }
        }
        if (!st.isEmpty() || rank != 1) {
            System.out.println("if");
            System.out.println("Invalid");
            return;
        }
        else{
            System.out.println("Valid String");
            System.out.println("Postfix : "+postfix);
            return;
        }
    }

    public static int inputPrior(char c){
        if (c == '+' || c == '-') {
            return 1;
        }
        else if (c == '*' || c == '/') {
            return 3;
        }
        else if (c == '^') {
            return 6;
        }
        else if (c == '(') {
            return 9;
        }
        else if (c == ')') {
            return 0;
        }
        else{
            return 7;
        }
    }

    public static int stackPrior(char c){
        if (c == '+' || c == '-') {
            return 2;
        }
        else if (c == '*' || c == '/') {
            return 4;
        }
        else if (c == '^') {
            return 5;
        }
        else if (c == '(') {
            return 0;
        }
        else if (c == ')') {
            return -1;
        }
        else{
            return 8;
        }
    }

    public static int getRank(char c){
        if ("+-*/^".indexOf(c) > -1) {
            return -1;
        }
        else if (c == '(' || c == ')') {
            return -10101;
        }
        else{
            return 1;
        }
    }
}
