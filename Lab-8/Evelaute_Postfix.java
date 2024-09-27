import java.util.Scanner;
import java.util.Stack;

public class Evelaute_Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Postfix Expression : ");
        String postfix = sc.next();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if ("+-/*^".indexOf(c) > -1) {
                int a = st.pop();
                int b = st.pop();
                switch (c) {
                    case '+':
                        st.push(b+a);
                        break;
                    case '-':
                        st.push(b-a);
                        break;
                    case '/':
                        st.push(b/a);
                        break;
                    case '*':
                        st.push(b*a);
                        break;
                    case '^':
                        st.push((int)Math.pow(b, a));
                        break;
                
                    default:
                        System.out.println("hello");
                        break;
                }
            }
            else{  
                st.push(c-'0');
            }
        }
        System.out.println(st.pop());
        sc.close();
    }
}