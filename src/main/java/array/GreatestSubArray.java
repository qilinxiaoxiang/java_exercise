package array;

public class GreatestSubArray {
    public static int getGreatesSubArraySum(int[] array) {
//        if (array.length == 0){
//            return 0;
//        }
        int current = 0;
        int sum = 0;
        for (int i : array) {
            if (current > 0) {
                current += i;
            }else {
                current = i;
            }
            if (current > sum) {
                sum = current;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getGreatesSubArraySum(new int[0]));
        System.out.println(getGreatesSubArraySum(new int[]{-1, 1,1,-1,-1}));
        System.out.println(getGreatesSubArraySum(new int[]{-1, 1,1,-1,-1,3}));
    }
}
