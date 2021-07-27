package array.加一;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 项峥
 * @Date: 2021/7/7 23:33
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        for (int digit : digits) {
            stack.push(digit);
        }
        List<Integer> list = new ArrayList<>();

        int carry = 0;
        Integer digit = stack.pop();
        int result = digit + 1 + carry;
        if (result > 9) {
            list.add(result - 10);
            carry = 1;
        } else {
            list.add(result);
            carry = 0;
        }
        while (!stack.isEmpty()) {
            digit = stack.pop();
            result = digit + carry;
            if (result > 9) {
                list.add(result - 10);
                carry = 1;
            } else {
                list.add(result);
                carry = 0;
            }
        }
        if (carry == 1) {
            list.add(1);
        }
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(list.size() - 1 - i);
        }
        return resultArray;

    }
}
