package com.test.data.data_struct.likedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "无用", "智多星");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.show();
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲', nickname='豹子头'}

        DoubleHeroNode heroNode5 = new DoubleHeroNode(4, "林冲New", "豹子头New");
        doubleLinkedList.update(heroNode5);
        doubleLinkedList.show();
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
//        HeroNode{no=3, name='无用', nickname='智多星'}
//        HeroNode{no=4, name='林冲New', nickname='豹子头New'}

        doubleLinkedList.del(3);
        doubleLinkedList.show();
//        HeroNode{no=1, name='宋江', nickname='及时雨'}
//        HeroNode{no=2, name='卢俊义', nickname='玉麒麟'}
//        HeroNode{no=4, name='林冲New', nickname='豹子头New'}

    }
}
