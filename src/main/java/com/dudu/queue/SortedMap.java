package com.dudu.queue;

import java.util.TreeSet;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/12/19 9:39 下午
 */
public class SortedMap {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>((item1,item2)->item2-item1);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(10);
        treeSet.comparator();
        for (Integer num :treeSet){
            System.out.print(num+"---");
        }
    }
}
