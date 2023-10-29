package leetcode.tree;

/**
 * @Description:
 * @Date: Created in 22:52 2023/10/28/0028
 * @Author: caopeng
 */
public class Flatten_114 {

    // 虚拟头节点，dummy.right 就是结果
    static TreeNode dummy = new TreeNode(-1);
    // 用来构建链表的指针
    static TreeNode p = dummy;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;

        traverse(root);
        System.out.println(1);
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        p.right = new TreeNode(root.val);
        p = p.right;
        traverse(root.left);
        traverse(root.right);
    }
}
