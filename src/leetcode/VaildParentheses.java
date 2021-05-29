package leetcode;

import java.util.Stack;

/**
 * @Description: leetcode 有效的括号
 * @Date: Created in 22:52 2021/5/29
 * @Author: caopeng
 */
public class VaildParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String parentheses = "([)]";
        boolean vaild = isVaild(parentheses);
        System.out.println(vaild);
    }

    /**
     * @Description: 有效的括号
     * @param str
     * @Return: boolean
     * @Date: 2021/5/29 22:54
     * @Author: caopeng
     */
    public static boolean isVaild(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        // 构造存数据的栈
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            // 只要遇到左括号 依次入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // 遇到右括号 pop出栈顶层的值与之比较  stack无元素时pop会抛异常
                if (stack.isEmpty()) {
                    return false;
                }
                Character leftValue = stack.pop();
                if (ch == ')') {
                    if (leftValue != '(') {
                        return false;
                    }
                } else if (ch == ']') {
                    if (leftValue != '[') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (leftValue != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
