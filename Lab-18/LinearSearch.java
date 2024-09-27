
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3,4,5,12,3,2,1};

        int x = linearSearch(arr, 12);
        
        if (x < 0) {
            System.out.println("Element doen't Exist in Array");
        }
        else{
            System.out.println("Element Found At Index : "+x);
        }

    }

    public static int linearSearch(int[] arr,int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
