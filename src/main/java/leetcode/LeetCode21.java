package leetcode;

/**
 * @Description: leetCode 21 合并两个有序链表
 * @Date: Created in 15:32 2021/11/6
 * @Author: caopeng
 */
public class LeetCode21 {

    /**
     *
     */
    public static void main(String[] args) throws InterruptedException {
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        // 1 - 2 - 4
        ListNode list1 = new ListNode(1, l2);
        l2.next = l4;
        // 1- 3- 5- 6
        ListNode list2 = new ListNode(1, l3);
        l3.next = l5;
        l5.next = l6;

        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 递归合并两个有序链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果两个链表有一个为null 则返回另一个非空链表
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        // 比较两个链表头节点的大小
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            // 递归结束之后返回 l1链表
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}

