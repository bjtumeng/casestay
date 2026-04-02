package com.dudu.leetcode.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 两数相加
 * 使用空间换时间
 * 特殊例子 [3,2,4] 使用map也能找到但是不正确
 * 直接在遍历的过程中寻找正确的数值
 * @author:zhaomeng
 * @date:2022/11/19 3:47 下午
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i]) != null){
                int k = map.get(target-nums[i]);
                result[0] = i;
                result[1] = k;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
