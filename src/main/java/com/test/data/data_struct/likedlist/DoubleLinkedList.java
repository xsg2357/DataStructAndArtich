package com.test.data.data_struct.likedlist;

public class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    /**
     * 显示链表[遍历]
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //head节点不能动 需要一个辅助遍历temp
        DoubleHeroNode temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            //输出节点
            System.out.println(temp);
            //后移 指向下一个节点
            temp = temp.next;
        }
    }

    public void add(DoubleHeroNode heroNode) {
        //head节点不能动 需要一个辅助遍历temp
        DoubleHeroNode temp = head;
        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //没有找到最后的节点 temp后移
            temp = temp.next;
        }
        //退出遍历 temp指向最后 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(DoubleHeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的no
        DoubleHeroNode temp = head.next;
        boolean flag = false; //判断添加的符号是否存在
        while (true) {
            if (temp == null) { //已经遍历完链表
                break;
            }
            if (temp.no == heroNode.no) {
                //寿命希望添加的节点的编号以然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            //插入链表
            System.out.printf("编号%d没有找到\n", heroNode.no);

        }
    }


    /**
     * 删除
     * 对于双向链表 可以直接找到要删除的节点
     */
    public void del(int no) {
        if (head.next == null){
            System.out.println("链表为空,无法删除");
            return;
        }
        DoubleHeroNode temp = head.next;
        boolean flag = false;//标识是否找到待删除节点
        while (true) {
            if (temp == null) {
                //已经到链表的最后节点的next
                break;
            }
            if (temp.no == no) {
                //已经找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
//            temp.next = temp.next.next;
            temp.pre.next = temp.next;
            //最后一个节点 不执行此举代码  否则会报空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("要删除的节点编号%d不存在\n", no);
        }
    }

}
