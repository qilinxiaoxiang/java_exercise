package binary.在D天内送达包裹的能力;

import java.util.Arrays;

/**
 * @Author: 项峥
 * @Date: 2021/7/21 21:17
 */
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().orElse(1);
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            if (canShipComplete(mid, weights, days)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean canShipComplete(int mid, int[] weights, int days) {
        int totalDays = 1;
        int onBoardWeight = 0;
        for (int weight : weights) {
            onBoardWeight += weight;
            if (onBoardWeight > mid) {
                totalDays += 1;
                onBoardWeight = weight;
            }
        }
        return totalDays <= days;
    }
}
