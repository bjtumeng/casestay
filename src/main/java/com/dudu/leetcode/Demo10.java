package com.dudu.leetcode;

/**
 * @Description:
 * 只出现一次的数字
 * @author:zhaomeng
 * @date:2022/11/13 10:07 下午
 */
public class Demo10 {
    public int singleNumber(int[] nums) {
        int result =nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
