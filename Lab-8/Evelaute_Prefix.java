import java.util.Scanner;
import java.util.Stack;

public class Evelaute_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix Expression : ");
        String prefix = sc.next();

        Stack<Integer> st = new Stack<>();

        for (int i = prefix.length()-1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if ("+-/*^".indexOf(c) > -1) {
                int a = st.pop();
                int b = st.pop();
                switch (c) {
                    case '+':
                        st.push(a+b);
                        break;
                    case '-':
                        st.push(a-b);
                        break;
                    case '/':
                        st.push(a/b);
                        break;
                    case '*':
                        st.push(a*b);
                        break;
                    case '^':
                        st.push((int)Math.pow(a, b));
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