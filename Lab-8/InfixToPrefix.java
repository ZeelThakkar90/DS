import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix : ");
        String inf = sc.next();

        StringBuilder sb = new StringBuilder(inf);
        sb = sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                sb.insert(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
                sb.insert(i, '(');
            }
        }
        sb.append(')');
        // System.out.println(sb);

        Stack<Character> st = new Stack<>();
        st.push('(');
        String prefix = "";

        for (int i = 0; i < sb.length(); i++) {
            if ("+-*/^()".indexOf(sb.charAt(i)) < 0) {
                prefix += sb.charAt(i);
            }

            else {
                if (sb.charAt(i) == '^') {
                    while (!st.isEmpty() && getPrior(st.peek()) >= getPrior(sb.charAt(i))) {
                        prefix += st.pop();
                    }
                    st.push(sb.charAt(i));
                } 
                else if (sb.charAt(i) == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        prefix += st.pop();
                    }
                    st.pop();
                } 
                else if (sb.charAt(i) == '(') {
                    st.push(sb.charAt(i));
                } 
                else {
                    // Normal Operator +-*/
                    while (!st.isEmpty() && getPrior(st.peek()) > getPrior(sb.charAt(i))) {
                        prefix += st.pop();
                    }
                    st.push(sb.charAt(i));
                }
            }
        }
        sb = new StringBuilder(prefix);
        System.out.println("Postfix = " + sb.reverse());
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
