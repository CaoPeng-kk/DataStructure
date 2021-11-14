package leetcode;

/**
 * @Description:
 * @Date: Created in 20:43 2021/11/9
 * @Author: caopeng
 */
public class LeetCode24 {

    public static void main(String[] args) {
        /**
         * leetcode 24 两两交换链表中的节点
         */
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        // 1- 3- 5- 6
        ListNode list2 = new ListNode(1, l3);
        l3.next = l5;
        l5.next = l6;
        l6.next = l4;
        l4.next = l2;

        ListNode res = swapPairs(list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 两两交换链表中的节点
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        // 哑头节点
        dummyHead.next = head;
        // 创建临时指针  用于记录当前位置
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = node1.next;
            // 将一号位置与三号位置关联
            node1.next = node2.next;
            // 将node2.next置为node1
            node2.next = node1;
            // 将链表头与头节点连接
            temp.next = node2;
            // !!!此处注意 虽然是将temp移动到下两个节点前 但是已经node 1 2已经进行交换了 所以这里应该是node1
            temp = node1;
        }
        return dummyHead.next;
    }
}
