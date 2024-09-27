import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix :");
        String inf = sc.next();
        inf += ')';
        Stack<Character> st = new Stack<>();
        st.push('(');
        String postfix = "";

        for (int i = 0; i < inf.length(); i++) {
            if ("+-*/^()".indexOf(inf.charAt(i)) < 0) {
                //not operator
                postfix += inf.charAt(i);
            } 
            
            else {
                if (inf.charAt(i) == '^') {
                    while (!st.isEmpty() && getPrior(st.peek()) > getPrior(inf.charAt(i))) {
                        postfix += st.pop();
                    }
                    st.push(inf.charAt(i));
                } 
                else if (inf.charAt(i) == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        postfix += st.pop();
                    }
                    st.pop();
                } 
                else if (inf.charAt(i) == '(') {
                    st.push(inf.charAt(i));
                } 
                else {
                    // Normal Operator +-*/
                    while (!st.isEmpty() && getPrior(st.peek()) >= getPrior(inf.charAt(i))) {
                        postfix += st.pop();
                    }
                    st.push(inf.charAt(i));
                }
            }
        }
        System.out.println("Postfix = " + postfix);
        sc.close();
    }

    public static int getPrior(char c) {
        int priority = -1;
        if (c == '^') {
            priority = 3;
            return priority;
        } else if (c == '*' || c == '/') {
            priority = 2;
            return priority;
        } else if (c == '+' || c == '-') {
            priority = 1;
            return priority;
        }
        return priority;
    }
}
