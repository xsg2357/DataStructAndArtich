package com.test.data.data_struct.likedlist;

import java.util.Stack;

public class LinkedListDemo {

    //方法：获取到单链表的节点的个数（如果是带头结点的链表，需要不统计头结点）
    public  static  int getLength(HeroNode headNode){
        //空链表
        if (headNode.next == null){
            return  0;
        }
        int  length = 0;
        HeroNode cur = headNode.next;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        return  length;
    }

    /**
     * 差值单链表中的倒数的第k个节点
     * 1.编写一个方法 接收head节点 同时接收一个index
     * 2.index表示倒数第index个节点
     * 3.先把链表从头到尾变了，得到链表的总的长度getLength
     * 4.得到size后 我们从链表的第一个开始遍历（size-index）个 就可以得到
     */
    public  static   HeroNode findLastIndexNode(HeroNode head,int  index){
        if (head.next == null){
            return  null;
        }
        int size = getLength(head);
        //index校验
        if (index <= 0 || index > size){
            return  null;
        }
        //定义一个辅助变量 for定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i <size - index ; i++) {
            cur = cur.next;
        }
        return  cur;
    }

    /**
     * 链表反转
     */
    public  static  void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return  ;
        }
        HeroNode cur  = head.next;//辅助指针 遍历原来的链表
        HeroNode next  = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //        从头到尾遍历原来的链表 每遍历一个节点 就将其取出 就放在链表的最前端
        while (cur!= null){
            next = cur.next;//暂时保存当前节点的下一个接待
            cur.next = reverseHead.next;//cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//cur后移
        }
        //将head.next 指向  reverseHead.next
        head.next  =  reverseHead.next;
    }

    /**
     * 栈实现反转
     */
    public static  void  reversePrint(HeroNode head){
        if (head.next == null ){
            return  ;
        }
        Stack<HeroNode> heroNodes = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表所有节点压入栈中
        while (cur != null){
            heroNodes.push(cur);
            cur = cur.next;
        }
        //stack的特点是先进后出
        while (heroNodes.size() >0){
            System.out.println(heroNodes.pop());
        }
    }



    public static void main(String[] args) {

        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "无用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建并加入链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

        //按编号加入
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
//        插入的编号2已经存在
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}


        singleLinkedList.show();

        HeroNode heroNode2New = new HeroNode(2, "卢俊义New", "玉麒麟New");
        singleLinkedList.update(heroNode2New);

        singleLinkedList.show();
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义New', nickname='玉麒麟New'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

        singleLinkedList.del(2);
        singleLinkedList.show();
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

        System.out.println("有效节点个数："+getLength(singleLinkedList.getHead()));
        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println(lastIndexNode);
//        有效节点个数：3
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

         reverseList(singleLinkedList.getHead());
        singleLinkedList.show();
//        HeroNode{no=4, name='林冲', nickname='豹子头'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=1, name='宋江', nickname='及时雨'}

        reversePrint(singleLinkedList.getHead());
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

    }

}
