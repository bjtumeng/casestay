package com.dudu.aviator;

import com.dudu.leetcode.ListNode;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/6/19 6:13 下午
 */
public class Demo {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i]!=0){
              int tmp = nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
          }
          j++;
        }
    }

}
