package jan.secondweek.stack;


import sun.awt.SunHints;

import javax.swing.plaf.TreeUI;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        HeroNode one = new HeroNode(1);
        HeroNode two = new HeroNode(2);
        HeroNode three = new HeroNode(3);
        HeroNode four = new HeroNode(4);

        linkedList.add(one);

        linkedList.list();
    }
}

class LinkedListStack {

    public int stackmaxSize;
    public int top = 0;
    private LinkedList stack = new LinkedList(stackmaxSize);

    public LinkedListStack(int maxSize) {
        this.stackmaxSize = maxSize;
    }

    //  设置一个标记，用来计数存入栈中的节点个数
    public int flag = 0;

    //判断栈空
    public boolean isEmpty(){
        return stack.getHead().next == null;
    }

    //判断栈满
    public boolean isFull() {
        //  设置一个标记，用来计数存入栈中的节点个数
        return top == stackmaxSize;
    }


    //定义入栈
    public void push(HeroNode node){
        //定义一个辅助变量，因为头节点不能动
        HeroNode temp = stack.getHead();
        //判断是否在链表末尾
        while (true){
            if (temp.next == null || !isFull() ){
                top++;
                node.no = top;
                temp.next = node;
            }
            temp = temp.next;
        }

    }

    //定义出栈
    public HeroNode pop(){
        //判断栈空
        if (isEmpty()){
            System.out.println("栈空了");
        }

        //辅助节点
        HeroNode temp = stack.getHead().next;
        while (true){
            if (temp.no == top){
                HeroNode value = temp;
                top--;
                return value;
            }
            temp = temp.next;
        }
    }

    //遍历栈
    public HeroNode list(){
        //判断栈是否为空，如果为空，直接返回
        if (isEmpty()){
            System.out.println("栈空了");
        }
        //定义一个辅助节点
        HeroNode temp = stack.getHead();
        for (int i = top; i > 0 ; i--) {
            System.out.printf("节点 %d \n");

        }
        return null;
    }

}

class LinkedList {

    private int maxSize;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public LinkedList(int maxSize) {
        this.maxSize = maxSize;
    }

    public LinkedList() {
    }

    //创建一个头节点
    private HeroNode head = new HeroNode(0,"",null);

    //获取头节点
    public HeroNode getHead(){

        return head;
    }

    public void add(HeroNode heroNode){
        //因为头节点不能动，所以需要辅助节点temp
        HeroNode temp = head;
        //需要判断链表的 .next 是否为空，因为要添加到链表的最后 这里使用循环
        //如果为空，就说明到了链表的末尾，跳出循环--将新的节点添加到末尾
        //
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while(true) {
            if(temp.next == null) {//说明temp已经在链表的最后
                break; //
            }
            if(temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在

                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值
        if(flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

}

class HeroNode {

    public int no;
    public String name;
    public HeroNode next; //指向下一个节点

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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode(int no, String name, HeroNode next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }

    public HeroNode(int no) {
        this.no = no;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
