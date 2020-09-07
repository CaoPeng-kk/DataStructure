package jan.secondweek.tree;

/**
 * @Author: caopeng
 * @Description: 二叉树的 前序 中序 后序遍历
 * @Date: Created in 10:34 2020/9/7
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        //根节点
        Node ross = new Node(1, "Ross");

        Node rachel = new Node(2, "Rachel");
        Node joey = new Node(3, "Joey");
        Node monica = new Node(4, "Monica");
        Node chandle = new Node(5, "Chandle");

        /**
         * 手动创建一个二叉树
         *              ross(1)
         *              |    \
         *       rachel(2)   joey(3)
         *                   |    \
         *            chandle(5)   monica(4)
         *
         */
        ross.setLeft(rachel);
        ross.setRight(joey);
        joey.setLeft(chandle);
        joey.setRight(monica);

        binaryTree.setRoot(ross);
        //前序遍历
        binaryTree.preOrder();
        System.out.println();
        //中序遍历
        binaryTree.infixOrder();
        System.out.println();
        //后序遍历
        binaryTree.postOrder();
        System.out.println();
    }


}

/**
 * @Description: 二叉树
 * @Param:
 * @return:
 * @Author: caopeng
 * @Date: 2020/9/7
 */
class BinaryTree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @Description: 前序遍历二叉树
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * @Description: 中序遍历二叉树
     * @Param: 
     * @return: 
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    
    /**
     * @Description: 后序遍历二叉树
     * @Param: 
     * @return: 
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}

class Node {

    /**
     * 节点信息
     */
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @Description: 二叉树的前序遍历
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void preOrder() {
        //输出当前节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * @Description: 中序遍历二叉树
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * @Description: 二叉树的后序遍历
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
