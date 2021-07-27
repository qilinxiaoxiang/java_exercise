package binary.爱吃香蕉的珂珂;

import java.util.Arrays;

/**
 * @Author: 项峥
 * @Date: 2021/7/21 20:26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE - left;
        while (left < right) {
            int mid = (left + right) / 2;
            int cost = eatTimeCost(mid, piles);
            if (cost > h) left = mid + 1;
            else right = mid;
            System.out.printf("mid:%d,left:%d,right:%d,cost:%d", mid, left, right, cost);
            System.out.println();
        }
        return right;
    }

    private int eatTimeCost(int mid, int[] piles) {
        return Arrays.stream(piles).map(p -> (int) Math.ceil((double) p / (double) mid)).sum();
    }

}
