package recursive.四数之和;

import java.util.*;

/**
 * @Author: 项峥
 * @Date: 2021/7/24 17:04
 */
public class Solution {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    int min = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        find(0, nums, target, 4);
        return new ArrayList<>(result);
    }

    void find(int left, int[] nums, int target, int count) {
        left = Math.max(left, min);
        if (nums.length - left < count) {
            return;
        }
        if (count == 1) {
            for (int i = nums.length - 1; i >= left; i--) {
                int num = nums[i];
                if (num == target) {
                    temp.add(num);
                    result.add(new ArrayList<>(temp));
                    min = i;
                    temp.remove(temp.size() - 1);
                }
            }
            return;
        }
        if (target > nums[nums.length - 1] * count || target < nums[left] * count) {
            return;
        }
        for (int i = left; i < nums.length; i++) {
            int num = nums[i];
            temp.add(num);
            find(i + 1, nums, target - num, count - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
