package jan.secondweek.tree.threadedbinarytree;

/**
 * @Author: caopeng
 * @Description: 线索化二叉树
 * @Date: Created in 15:25 2020/9/10
 */
public class ThreadedBinaryTree {

    public static void main(String[] args) {

        //根节点
        Node ross = new Node(1, "ross");

        Node rachel = new Node(3, "Rachel");
        Node joey = new Node(6, "Joey");
        Node chandle = new Node(14, "Chandle");
        Node phebe = new Node(8, "Phebe");
        Node cat = new Node(10, "cat");

        /**
         * 手动创建一个二叉树
         *                 ross(1)
         *               /       \
         *       rachel(3)       joey(6)
         *       /    \          /
         *  phebe(8) cat(10)  chandle(14)
         *
         */
        ross.setLeft(rachel);
        ross.setRight(joey);
        rachel.setLeft(phebe);
        rachel.setRight(cat);
        joey.setLeft(chandle);

        //测试线索化
        BinaryTree binaryTree = new BinaryTree();
        //设置根节点
        binaryTree.setRoot(ross);
        //线索化操作
        binaryTree.threadedBinaryTree();

        //检验是否线索化
        Node leftNode = rachel.getLeft();
        int leftType = rachel.getLeftType();
        Node rightNode = rachel.getRight();
        int rightType = rachel.getRightType();
        System.out.println("左"+leftNode+"  类型"+leftType+"  |  "+"右"+rightNode+"  类型"+rightType);
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

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在进行线索化时 pre总是指向前驱结点
    private Node pre = null;

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

    /**
     * @Description: 前序二叉查找方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public Node preOrderSearch(Node nodeNo) {
        if (this.root != null) {
            return this.root.preOrderSearch(nodeNo);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * @Description: 中序二叉查找方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public Node infixOrderSearch(Node nodeNo) {
        if (this.root != null) {
            return this.root.infixOrderSearch(nodeNo);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * @Description: 后序二叉查找方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public Node postOrderSearch(Node nodeNo) {
        if (this.root != null) {
            return this.root.postOrderSearch(nodeNo);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * @Description: 删除结点方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public void deleteNode(Node targetNode) {
        if (this.root != null) {
            if (this.root.getNo() == targetNode.getNo()) {
                root = null;
                return;
            }
            this.root.deleteNode(targetNode);
        }
    }

    /**
     * @Description: 线索化二叉树 (中序线索化二叉树方法
     *               就是将二叉树的叶子结点上闲置的左右指针域指向该结点在某种遍历次序下的前驱结点
     *               和后继节点
     * @Param: Node 当前需要线索化的结点（传入一个二叉结点树
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/10
     *               1
     *            /    \
     *          3       6
     *        /  \    /   \
     *      8    10  14
     *
     * 此树中序遍历的结果为 8，3，10，1，14，6
     *
     */
    public void threadedBinaryTree(Node targetNode) {

        //如果要线索化的结点为空，则直接返回
        if (targetNode == null) {
            return;
        }
        //1. 递归先线索化左子树
        if (targetNode.getLeft() != null) {
            threadedBinaryTree(targetNode.getLeft());
        }
        //2. 线索化本结点(little hard
        /**
         * 处理当前结点的前驱结点
         * 以8结点来理解 (8结点的left = null lefttype = 1
         */
        if (targetNode.getRight() == null) {
            //设置当前结点的左指针指向前驱结点
            targetNode.setLeft(pre);
            //设置当前结点的左指针指向的类型为指向前驱结点
            targetNode.setLeftType(1);
        }

        //处理后继结点 (第一次pre = null 不会进入 (纠正视频一个bug
        if (pre != null) {
            if (pre.getRight() == null) {
                //将pre的后继结点设置为本结点
                pre.setRight(targetNode);
                //设置指向类型
                pre.setRightType(1);
            }
        }
        // 重要！ 当第一次走到此位置时，将8结点设置为前驱结点(每处理一个结点，就让当前结点成为下一个结点的
        // 前驱结点
        pre = targetNode;

        //3. 递归线索化右子树
        if (targetNode.getRight() != null) {
            threadedBinaryTree(targetNode.getRight());
        }
    }

    /**
     * @Description: 线索化二叉树无参重载方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/10/13
     */
    public void threadedBinaryTree() {
        threadedBinaryTree(root);
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

    /**
     * 线索化二叉树时 左右结点的指向类型
     * 规定；如果leftType = 0 ,则指针域指向左子树，leftType = 1 ,则指针域指向前驱结点，
     *      如果rightType = 0 ,则指针域指向右子树，rightType = 1 ,则指针域指向后继结点
     */
    private int leftType;
    private int rightType;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
     * @Description: 线索化二叉树方法 
     * @Param: 
     * @return: 
     * @Author: caopeng
     * @Date: 2020/9/10
     */
    public void threadedBinaryTree() {
        
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

    /**
     * @Description: 二叉前序查找方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     *                             ross(1)
     *                            /       \
     *                    rachel(2)       joey(3)
     *                    /    \          /      \
     *             phebe(6) cat(7)  chandle(5)   monica(4)
     */
    public Node preOrderSearch(Node NodeNo) {
        //先判断当前节点是否等于要查找的 是就返回 不是就递归前序查找
        if (this.no == NodeNo.no) {
            return this;
        }
        Node result = null;
        //判断当前节点的左子节点是否为空 如果不为空 则递归前序查找 找到就返回 没找到就对右子节点递归查找
        if (this.left != null) {
            result = this.left.preOrderSearch(NodeNo);
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(NodeNo);
        }
        return result;
    }

    /**
     * @Description: 中序遍历查找 (中序跟后序的方法跟前序的写法有差别)
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/7
     */
    public Node infixOrderSearch(Node NodeNo) {
        //先判断左子树是否为空 递归遍历比较 然后比较根节点 然后递归遍历右节点比较
        Node result = null;
        if (this.left != null) {
            if (this.left.no == NodeNo.no) {
                result = this.left;
                return result;
            } else {
                result = this.left.infixOrderSearch(NodeNo);
            }
        }
        if (result != null) {
            return result;
        }
        if (this.no == NodeNo.no) {
            result = this;
            return result;
        }
        if (this.right != null) {
            if (this.right.no == NodeNo.no) {
                result = this.right;
                return result;
            } else {
                result = this.right.infixOrderSearch(NodeNo);
            }
        }
        return result;
    }

    /**
     * @Description: 后序二叉查找
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public Node postOrderSearch(Node NodeNo) {
        /**
         * 判断当前节点的左子节点是否为空，如果非空 则遍历左子节点后序查找 找到就返回，左子节点遍历完成之后
         * 判断当前节点的右子节点是否为空，如果非空 则遍历右子节点后序查找 找到就返回
         * 最后与根节点比较 匹配就返回 否则返回null
         */
        Node result = null;
        if (this.left != null) {
            if (this.left.no == NodeNo.no) {
                result = this.left;
                return result;
            } else {
                result = this.left.postOrderSearch(NodeNo);
            }
        }
        //如果左子树找到了 就直接返回
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            if (this.right.no == NodeNo.no) {
                result = this.right;
                return result;
            } else {
                result = this.right.postOrderSearch(NodeNo);
            }
        }
        if (this.no == NodeNo.no) {
            result = this;
            return result;
        }
        return result;
    }

    /**
     * @Description: 删除结点方法
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/8
     */
    public void deleteNode(Node targetNode) {
        /**
         * 如果删除的结点是叶子结点，则删除该结点  如果删除的结点是非叶子结点 则删除该树
         *
         * 1.先判断此树是否为空树 如果为只有一个root结点的空树 则等价于将此树清空
         * 2. 因为此二叉树是单向的 所以要判断当前结点的子结点是否为要删除的结点，如果当前结点的左子结点为非空 则this.left = null
         *    并且返回（结束递归删除）
         * 3. 判断当前结点的右子结点是否为要删除的结点，如果当前结点的右子结点为非空 则this.left = null
         * 4. 如果 2 3 都没有删除结点 那就向左子树递归删除
         * 5. 如果 4 也没有删除结点 那就向右子树递归删除
         *
         */
        if (this.left == null && this.right == null) {
            return;
        }
        if (this.left != null) {
            if (this.left.no == targetNode.no) {
                this.left = null;
                return;
            } else if (this.right != null) {
                if (this.right.no == targetNode.no) {
                    this.right = null;
                    return;
                }
                this.left.deleteNode(targetNode);
                this.right.deleteNode(targetNode);
            }
        }
    }

}