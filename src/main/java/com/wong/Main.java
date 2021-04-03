package com.wong;

public class Main{
    public static void main(String[] args) {
        List<Integer> list = new LinkList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(2,2222);
        list.add(list.size(),0);

        System.out.println(list);

        list.remove(4);

        System.out.println(list);
    }
}
