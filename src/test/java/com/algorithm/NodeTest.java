package com.algorithm;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;

public class NodeTest {

    @Test
    public void bFun(){
        BigDecimal a = new BigDecimal("0.0");
        BigDecimal b = new BigDecimal("0.00");
        System.out.println(a == b);
        System.out.println(a.equals(b));


    }

    @Test
    public void revNodeList(){
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "赵六");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node1);
        // singleLinkedList.print();
        // System.out.println(singleLinkedList.getLength());
        // singleLinkedList.reversePrint();
        // singleLinkedList.reverse();
        // singleLinkedList.reverse(singleLinkedList.getHead());
        // singleLinkedList.print();

        Node node7 = new Node(7, "王五");
        Node node9 = new Node(9, "赵六");
        singleLinkedList.addByOrder(node7);
        singleLinkedList.addByOrder(node9);
        // singleLinkedList.print();
        singleLinkedList.print();
        node7.setName("王五五");
        singleLinkedList.update(node7);
        System.out.println("修改后");
        singleLinkedList.print();



    }


    class SingleLinkedList {
        private Node head = new NodeTest.Node(0, "");

        public Node getHead(){
            return head;
        }

        public void update(Node newNode) {

            Node temp = head;
            while (true){
                if (temp.no.equals(newNode.no)) {
                    break;
                }
                temp = temp.next;
                if(temp.next == null){
                    temp = head;
                    break;
                }
            }

            if(temp.no == null){
                System.err.println("未找到数据");
                return;
            }

            temp.name = newNode.name;
        }

        public void addByOrder(Node node){
            if(node == null){
                System.err.println("node为空");
                return;
            }

            if(head.next == null){
                head.next = node;
                return;
            }

            Node temp = head;
            Integer no = node.getNo();
            while (true){
                if(temp.next == null){
                    break;
                }
                if (no.equals(head.getNo())) {
                    System.err.println("已存在不可添加");
                    break;
                }
                else if(temp.next.no > no){
                    // 找到了， 在它后边插入
                    System.out.println("找到了在它后边插入");
                    break;
                }

                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;

        }

        //将单链表反转
        public void reversetList(Node head) {
            //如果当前链表为空，或者只有一个节点，无需反转，直接返回
            if(head.next == null || head.next.next == null) {
                return ;
            }

            //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
            Node cur = head.next;
            Node next = null;// 指向当前节点[cur]的下一个节点
            Node reverseHead = new Node(0, "");
            //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
            //动脑筋
            while(cur != null) {
                next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
                cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
                reverseHead.next = cur; //将cur 连接到新的链表上
                cur = next;//让cur后移
            }
            //将head.next 指向 reverseHead.next , 实现单链表的反转
            head.next = reverseHead.next;
        }

        // 反转链表
        public void reverse(Node head){
            if(head.next == null){
                System.err.println("链表是空的");
            }

            if(head.next.next == null){
                System.out.println("无需反转");
            }

            Node cur = head.next;
            Node next = null;
            Node revHead = new Node(0, "");
            while (cur != null) {
                next = cur.next;
                cur.next = revHead.next;
                revHead.next = cur;
                cur = next;
            }
            head.next = revHead.next;
        }

        // 添加节点
        public void add(Node node){
            Node temp = head;
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;

        }

        /**
         * 打印链表
         */
        public void print() {
            Node temp = head;
            while (temp.next != null){
                System.out.println(temp.next.toString());
                temp = temp.next;
            }
        }

        // 获取长度
        public int getLength(){
            if(head.next == null){
                return 0;
            }

            int length = 1;
            Node temp = head.next;
            while (temp.next != null){
                length++;
                temp = temp.next;
            }

            return length;

        }

        // 反向打印链表
        public void reversePrint(){
            if(head.next == null){
                System.err.println("链表是空的");
            }

            Stack<Node> stack = new Stack<>();
            Node temp = head;
            while (temp.next != null){
                stack.add(temp.next);
                temp = temp.next;
            }

            while (!stack.empty()) {
                System.out.println(stack.pop());
            }
        }



    }

    class Node{
        private Integer no;
        private String name;
        private Node next;

        public Node() {
        }

        public Node(Integer no, String name) {
            this.no = no;
            this.name = name;
        }

        public Node(String name, Node next) {
            this.name = name;
            this.next = next;
        }

        public Node(Integer no, String name, Node next) {
            this.no = no;
            this.name = name;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Integer getNo() {
            return no;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}





