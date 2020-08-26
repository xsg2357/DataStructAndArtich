package com.test.data.data_struct.likedlist;

public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.show();

        //小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);
//        小孩的编号1
//        小孩的编号2
//        小孩的编号3
//        小孩的编号4
//        小孩的编号5
//        小孩2出圈
//        小孩4出圈
//        小孩1出圈
//        小孩5出圈
//        last boy no is 3

    }
}

/**
 * 单向环形列表
 */
class  CircleSingleLinkedList{
    //first 节点 当前没有编号
    private  Boy first = new Boy(-1);

    //构建环形列表 加入
    public  void  addBoy(int nums){
        if (nums <1 ){
            System.out.println("nums is not right");
            return;
        }
        Boy curBoy = null;//辅助节点
        for (int i = 1; i <= nums ; i++) {
            //根据编号 创建节点
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//curBoy->first
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历循环列表
    public  void  show(){
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // first 不能动 辅助指针完成遍历
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            //curBoy 后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo 从哪个小孩开始数
     * @param countNum 表示数几下
     * @param nums 有多少小孩在圈中
     */
    public  void  countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo <1 || startNo >nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //辅助指针 帮助小孩出圈
        Boy helper = first;
        while (true){
            //helper只想了最后一个节点
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前 先让first和heler移动k-1次
        for (int i = 0; i <startNo-1 ; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //小孩报数时 让first和helper指针同时移动m-1次
        //循环操作 直到圈中只有一个节点
        while (true){
            if (helper == first){ //圈中只有一个节点
                break;
            }
            //first和helper指针同时移动m-1次
            for (int i = 0; i <countNum-1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //first->节点 ==> 出圈的小孩的节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first); //构建出圈后面的新环形链表
        }
        System.out.printf("last boy no is %d \n",first.getNo());
    }

}

/**
 * Boy节点
 */
class  Boy {

    private  int  no;
    private  Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
