package com.dudu.leetcode;

/**
 * @Description:
 * 多数元素
 * @author:zhaomeng
 * @date:2022/11/13 9:50 下午
 */
public class Demo9 {
    public static int majorityElement(int[] nums) {
      int target =0;
      int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (count ==0){
                target =nums[i];
            }
            if (target == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{2,2,1,1,3,4,5,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
