package leetcode;

/**
 * @Description: 公共链表
 * @Date: Created in 20:32 2021/11/9
 * @Author: caopeng
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}