import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Postfix Expression : ");
        String postfix = sc.next();

        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            String c = postfix.charAt(i) + "";
            if ("+-/*^".contains(c)) {
                String a = st.pop();
                String b = st.pop();
                if(a.length()==1 && b.length()==1){
                    st.push(b+c+a);
                }else
                st.push('('+b+c+a+')');
            }
            else{  
                st.push(c);
            }
        }
        System.out.println(st.pop());
        sc.close();
    }
}
