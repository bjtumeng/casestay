package com.dudu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/11/15 11:03 下午
 */
public class Demo14 {
    public static void main(String[] args) {
        int [] result = new int[]{3,2,4};
        System.out.println(twoSum(result, 6)[0]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i]) != null){
                int k = map.get(target-nums[i]);
                result[0] = i;
                result[1] = k;
                return result;
            }
        }
        return result;
    }
}
