import java.util.Arrays;
import java.util.HashMap;

public class CountingSortHashMap {
    public static void main(String[] args) {

        int a[] = {-1,2,0,-5,3,2};

        HashMap<Integer,Integer> mp = new HashMap<>();
        int min = a[0];
        int max = a[0];
        for(int i=0;i<a.length;i++){
            mp.put(a[i] , mp.getOrDefault(a[i], 0)+1);
            max = Math.max(a[i],max);
            min = Math.min(a[i],min);
        }
        
        int temp = mp.get(min);
        for(int i=min+1;i<=max;i++){
            if(mp.containsKey(i)){
                mp.put(i,(mp.get(i)+temp));
                temp = mp.get(i);
            }
        }

        int ans[] = new int[a.length];

        for(int i=a.length-1;i>=0;i--){
            ans[mp.get(a[i])-1] = a[i];

            mp.put(a[i],mp.get(a[i])-1);
        }

        System.out.println(Arrays.toString(ans));
    }
}
