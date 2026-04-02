package com.dudu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 找到所有数组中消失的数字
 * 不用交换需要置为-1
 * @author:zhaomeng
 * @date:2022/11/13 4:35 下午
 */
public class Demo6 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           if (nums[Math.abs(nums[i])-1]>0){
               nums[Math.abs(nums[i])-1] = - nums[Math.abs(nums[i])-1];
           }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [] nums =new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        for (int i=0;i<disappearedNumbers.size();i++){
            System.out.print(disappearedNumbers.get(i));
        }
    }
}
