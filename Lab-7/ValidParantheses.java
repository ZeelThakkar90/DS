import java.util.Scanner;
import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            System.out.println(isValid(str));
        }
        sc.close();
    }

    public static int isValid(String str) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } 
            else {
                if (!st.isEmpty()) {
                    char top = st.lastElement();
                    if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                        st.pop();
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        if (st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
