package linkedlist.合并两个有序链表;

import linkedlist.ListNode;

import java.util.Optional;

/**
 * @Author: 项峥
 * @Date: 2021/7/7 23:57
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cursor = sentinel;
        while (l1 != null || l2 != null) {
            if (l1 != null && l1.val <= Optional.ofNullable(l2).map(l -> l.val).orElse(Integer.MAX_VALUE)) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }
        return sentinel.next;
    }
}
