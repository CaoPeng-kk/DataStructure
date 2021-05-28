package leetcode;

/**
 * @Author: caopeng
 * @Description: 力扣两数之和相加
 * @Date: Created in 22:42 2021/2/20
 */
public class TwoNumberSum {
    /**
     * 两数相加，给你两个非空的链表，表示两个非负的整数，它们每位数字都是按照逆序的方式存储的
     * 并且每个结点只能存储一位数字
     * 请你将两个数相加，并以相同形式返回一个表示和的链表
     * 你可以假设除了数字0之外，这两个数字都不会以0开头
     *
     * eg；输入；2-4-3
     *          5-6-4
     *     输出 7-0-8
     */
    public static void main(String[] args) {
        ListNode l1three = new ListNode(3);
        ListNode l1two = new ListNode(4, l1three);
        ListNode l1one = new ListNode(2, l1two);

        ListNode l2three = new ListNode(4);
        ListNode l2two = new ListNode(6, l2three);
        ListNode l2one = new ListNode(5, l2two);
        // test case 2

        ListNode l17 = new ListNode(9);
        ListNode l16 = new ListNode(9, l17);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l11 = new ListNode(9, l12);

        ListNode l24 = new ListNode(9);
        ListNode l23 = new ListNode(9, l24);
        ListNode l22 = new ListNode(9, l23);
        ListNode l21 = new ListNode(9, l22);
        // 打印结果链表
        ListNode resNode = addTwoNumber(l11, l21);
        while (resNode != null) {
            System.out.print(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    /**
     * @Description: 将两个链表相加
     * @param l1  @param l2
     * @Return: leetcode.ListNode
     * @Author: caopeng
     * @Date: 2021/2/23 0:05
     */
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        // 两个链表对应位相加之和
        int total;
        // 进位标志位 值为0 或1
        int next = 0;
        // 定义返回的结果链表
        ListNode res = new ListNode();
        // 设置一个辅助指针 用来移动 而不是直接操作res
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            total = l1.val + l2.val + next;
            // 计算是否需要进位
            next = total / 10;
            cur.next = new ListNode(total % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        // 当有一条链表的next为null时 会走到这里
        while (l1 != null) {
            total = l1.val + next;
            next = total / 10;
            cur.next = new ListNode(total % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            total = l2.val + next;
            next = total / 10;
            cur.next = new ListNode(total % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        // 到这里还要判断next标志位是否有值
        if (next != 0) {
            cur.next = new ListNode(next);
        }
        return res.next;
    }
}

/**
 * 节点
 */
class ListNode {

    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}