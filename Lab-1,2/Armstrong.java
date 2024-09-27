
public class Armstrong {
    public static void main(String[] args) {
        System.out.println("Armstrong Number in Range of 1-1000 are :");
        for (int i = 1; i <= 1000; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }

    }
    public static boolean isArmstrong(int n){
        int temp = n;
        int sum = 0;
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        n = temp;
        while (n > 0) {
            int ld = n % 10;
            sum += Math.pow(ld, count);
            n = n / 10;
        }
        if (sum == temp) {
            return true;
        }
        return false;
    }
}
