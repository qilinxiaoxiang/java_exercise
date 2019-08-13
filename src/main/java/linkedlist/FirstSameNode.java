package linkedlist;


import java.util.Stack;

// https://www.weiweiblog.cn/findfirstcommonnode/
public class FirstSameNode {
    public ListNode getFirstSameNode(ListNode head1, ListNode head2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(head1 != null) {
            s1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2);
            head2 = head2.next;
        }
        ListNode result = null;
        while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
            s1.pop();
            result = s2.pop();
        }
        return result;
    }
}
