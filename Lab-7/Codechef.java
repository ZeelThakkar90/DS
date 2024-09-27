import java.util.*;

public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
			sc.nextLine();
		    String s = sc.nextLine();
		    Stack<Character> s1 = new Stack<>();
		    Stack<Character> s2 = new Stack<>();
            boolean flag = false;
		    for(int i=0;i<n;i++){
                char c = s.charAt(i);
		        if(!isVowel(c)){
                    if(!flag){
                        s1.push(c);
                    }else{
                        s2.push(c);
                    }
                }else{
                    if(!flag){
                        while(!s1.isEmpty()){
                            s2.push(s1.pop());
                        }
                        s2.push(c);
                    }else{
                        while(!s2.isEmpty()){
                            s1.push(s2.pop());
                        }
                        s1.push(c);
                    }
                    flag = !flag;
                }
		    }
            StringBuilder sb1 = new StringBuilder();
            if(flag){
                while(!s2.isEmpty()){
                    sb1.append(s2.pop());
                }
            }else{
                while(!s1.isEmpty()){
                    sb1.append(s1.pop());
                }
            }
            System.out.println(sb1.reverse().toString());
            sc.close();
		}

	}
	public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
