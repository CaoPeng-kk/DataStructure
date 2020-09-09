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
        Node phebe = new Node(6, "Phebe");
        Node cat = new Node(7, "cat");

        /**
         * 手动创建一个二叉树
         *                 ross(1)
         *               /       \
         *       rachel(2)       joey(3)
         *       /    \          /         \
         *  phebe(6) cat(7)  chandle(5)   monica(4)
         *
         */
        ross.setLeft(rachel);
        ross.setRight(joey);
        rachel.setLeft(phebe);
        rachel.setRight(cat);
        joey.setLeft(chandle);
        joey.setRight(monica);

        //设置根节点
        binaryTree.setRoot(ross);
        //前序遍历
        System.out.println("----前序遍历");
        binaryTree.preOrder();
        System.out.println();
        //中序遍历
        System.out.println("----中序遍历");
        binaryTree.infixOrder();
        System.out.println();
        //后序遍历
        System.out.println("----后序遍历");
        binaryTree.postOrder();
        System.out.println();

        //测试前序查找
        Node node2 = binaryTree.preOrderSearch(cat);
        System.out.println("前序遍历查找到结点为  " + node2);
        System.out.println();

        //测试中序二叉查找
        Node node = binaryTree.infixOrderSearch(chandle);
        System.out.println("中序遍历查找到结点为  " + node);
        System.out.println();

        //测试后序二叉查找
        Node node1 = binaryTree.postOrderSearch(chandle);
        System.out.println("后序遍历查找到结点为  " + node1);
        System.out.println();

        //测试删除结点
        System.out.println("----测试删除结点");
        binaryTree.deleteNode(monica);
        System.out.println();

        binaryTree.preOrder();
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
    public Node preOrderSearch(Node nodeNo) {
        //先判断当前节点是否等于要查找的 是就返回 不是就递归前序查找
        if (this.no == nodeNo.no) {
            return this;
        }
        Node result = null;
        //判断当前节点的左子节点是否为空 如果不为空 则递归前序查找 找到就返回 没找到就对右子节点递归查找
        if (this.left != null) {
            result = this.left.preOrderSearch(nodeNo);
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(nodeNo);
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
    public Node infixOrderSearch(Node nodeNo) {
        //先判断左子树是否为空 递归遍历比较 然后比较根节点 然后递归遍历右节点比较
        Node result = null;
        if (this.left != null) {
            if (this.left.no == nodeNo.no) {
                result = this.left;
                return result;
            } else {
                result = this.left.infixOrderSearch(nodeNo);
            }
        }
        if (result != null) {
            return result;
        }
        if (this.no == nodeNo.no) {
            result = this;
            return result;
        }
        if (this.right != null) {
            if (this.right.no == nodeNo.no) {
                result = this.right;
                return result;
            } else {
                result = this.right.infixOrderSearch(nodeNo);
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
    public Node postOrderSearch(Node nodeNo) {
        /**
         * 判断当前节点的左子节点是否为空，如果非空 则遍历左子节点后序查找 找到就返回，左子节点遍历完成之后
         * 判断当前节点的右子节点是否为空，如果非空 则遍历右子节点后序查找 找到就返回
         * 最后与根节点比较 匹配就返回 否则返回null
         */
        Node result = null;
        if (this.left != null) {
            if (this.left.no == nodeNo.no) {
                result = this.left;
                return result;
            } else {
                result = this.left.postOrderSearch(nodeNo);
            }
        }
        //如果左子树找到了 就直接返回
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            if (this.right.no == nodeNo.no) {
                result = this.right;
                return result;
            } else {
                result = this.right.postOrderSearch(nodeNo);
            }
        }
        if (this.no == nodeNo.no) {
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
