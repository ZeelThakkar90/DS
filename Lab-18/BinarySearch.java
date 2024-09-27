public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,4,5,12,3,2,1};

        int x = binarySearch(arr,4);
        
        if (x < 0) {
            System.out.println("Element doen't Exist in Array");
        }
        else{
            System.out.println("Element Found At Index : "+x);
        }
    }

    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == key) {
                return mid;
            }

            else if (key < arr[mid]) {
                high = mid-1;
            }

            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
