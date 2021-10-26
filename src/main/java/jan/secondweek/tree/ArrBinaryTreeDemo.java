package jan.secondweek.tree;

/**
 * @Author: caopeng
 * @Description: 顺序存储二叉树 (将二叉树的结点按二叉树中的顺序存储到数组中 (将数组中的数据按
 *               二叉树的顺序遍历出来
 * @Date: Created in 21:02 2020/9/8
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        arrBinaryTree.preOrderArr();

    }
}

class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * @Description: 重载方法 自动传入0 避免每次传值
     * @Param:
     * @return:
     * @Author: caopeng
     * @Date: 2020/9/9
     */
    public void preOrderArr() {
        preOrderArr(0);
    }

    /**
     * @Description: 顺序遍历二叉树 (以二叉树前序遍历的方式 遍历数组)
     * @Param: int 数组的角标
     * @return: void
     * @Author: caopeng
     * @Date: 2020/9/9
     */
    public void preOrderArr (int index) {
        /**
         * 规定 n为二叉树中的结点元素在数组中对应的角标
         * 则 在二叉树中 n结点的左子节点的角标为 (2*n+1) 右子节点的角标为 (2*n+2) 父节点为 (n-1)/2
         */
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能遍历");
        }
        //打印当前结点
        System.out.println(arr[index]);
        //先递归左子树 校验角标
        if ((index * 2 + 1) < arr.length) {
            //如果角标合法的情况下 递归遍历 输出结点
            preOrderArr((index * 2 + 1));
        }
        //递归遍历右子树
        if ((index * 2 + 2) < arr.length) {
            preOrderArr((index * 2 + 2));
        }
    }
}
