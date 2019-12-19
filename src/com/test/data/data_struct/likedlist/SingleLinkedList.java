package com.test.data.data_struct.likedlist;

/**
 * 定义单链表
 */
public class SingleLinkedList {

    //头结点
    private  HeroNode head = new HeroNode(0,"","");

    /**
     * 返回头结点
     */
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //不考虑编号顺序
    // 找到当前链表的最后节点
    // 将最后节点的next指向新的节点
    public  void add(HeroNode heroNode){
        //head节点不能动 需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //没有找到最后的节点 temp后移
            temp = temp.next;
        }
        //退出遍历 temp指向最后
        temp.next = heroNode;
    }

    /**
     * 通过排名来添加 有成功 反之失败
     */
    public  void addByOrder(HeroNode heroNode){
        //头大节点不能动 通过辅助变量来找到添加的位置
        //单链表 temp是位于添加位置的前一个节点 否则插入不了

        HeroNode temp  =head;
        boolean flag = false; //判断添加的符号是否存在
        while (true){
            if (temp.next == null){ //temp已经存在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){ //位置找到 就在temp的后面插入
                break;
            }else  if (temp.next.no == heroNode.no){
                //寿命希望添加的节点的编号以然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("插入的编号%d已经存在\n",heroNode.no);
        }else{
            //插入链表
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * 修改节点信息 根据no编号来修改 no编号不能修改
     * heroNode 的no编号来修改
     */
    public  void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的no
        HeroNode temp  =head.next;
        boolean flag = false; //判断添加的符号是否存在
        while (true){
            if (temp == null){ //已经遍历完链表
                break;
            }
            if (temp.no == heroNode.no){
                //寿命希望添加的节点的编号以然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;

        }else{
            //插入链表
            System.out.printf("编号%d没有找到\n",heroNode.no);

        }
    }

    /**
     * 删除节点
     */
    public  void  del(int no){
        HeroNode temp  =head;
        boolean flag =  false;//标识是否找到待删除节点
        while (true){
            if (temp.next == null){
                //已经到链表的最后
                break;
            }
            if (temp.next.no == no){
                //已经找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的节点编号%d不存在\n",no);
        }
    }

    /**
     * 显示链表[遍历]
     */
    public  void  show(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //head节点不能动 需要一个辅助遍历temp
        HeroNode temp = head.next;
        while (true){
            //判断链表是否到最后
            if (temp == null){
                break;
            }
            //输出节点
            System.out.println(temp);
            //后移 指向下一个节点
            temp = temp.next;
        }
    }

}
