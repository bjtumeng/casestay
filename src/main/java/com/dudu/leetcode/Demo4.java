package com.dudu.leetcode;

import java.util.*;

/**
 * @Description:
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * @author:zhaomeng
 * @date:2021/11/28 6:21 下午
 */
public class Demo4 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] array =new int[arr1.length];
        Set<Integer> sets = new HashSet<>();
        int index=0;
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        for (int j=arr1.length-1;j>=0;j--){
           if (hashMap.get(arr1[j])!=null){
               hashMap.put(arr1[j],hashMap.get(arr1[j])+1);
           }else{
               hashMap.put(arr1[j],1);
           }
        }
        for (int i=0;i<arr2.length;i++){
            sets.add(arr2[i]);
            if (hashMap.get(arr2[i])!= null){
                Integer integer = hashMap.get(arr2[i]);
                while(integer>0){
                    array[index] =arr2[i];
                    index++;
                    integer--;
                }
            }
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!sets.contains(arr1[i])){
                integers.add(arr1[i]);
                index++;
            }
        }
        Collections.sort(integers);
        for (int i = 0; i < integers.size(); i++) {
            array[index] =integers.get(i);
            index++;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] root1 ={2,3,1,3,2,4,6,7,9,2,19};
        int [] root2 ={2,1,4,3,9,6};
        int[] ints = relativeSortArray(root1, root2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+"|");
        }
    }
}
