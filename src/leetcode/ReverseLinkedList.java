package leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Description: leetcode 反转链表
 * @Date: Created in 23:45 2021/5/30
 * @Author: caopeng
 */
public class ReverseLinkedList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     */
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2, one);
        ListNode three = new ListNode(3, two);
        ListNode four = new ListNode(4, three);
        ListNode head = new ListNode(5, four);
        ListNode reverseRes = reverse(head);
        while (reverseRes != null) {
            System.out.print(reverseRes.val + " ");
            reverseRes = reverseRes.next;
        }

    }

    /**
     * 反转链表
     * dammy --> 1-> 2-> 3-> 4-> 5
     * 1就是head节点
     */
    public static ListNode reverse(ListNode head) {
        // 临时变量 记录head的next节点
        ListNode next;
        // 临时变量 记录dammy的next的节点
        ListNode temp;
        // 临时变量 指向head节点
        ListNode dammy = new ListNode();
        dammy.next = head;
        // node就是head节点
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            next = head.next;
            temp = dammy.next;
            head.next = next.next;
            dammy.next = next;
            next.next = temp;
        }
        return dammy.next;
    }
}

