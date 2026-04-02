package com.dudu.leetcode;

import java.util.stream.Stream;

/**
 * @Description:
 * 找规律 比特位计数
 * @author:zhaomeng
 * @date:2022/11/13 4:04 下午
 */
public class Demo {
    public static int[] countBits(int n) {
        int[] nums = new int[n+1];
        nums[0] =0;
        int target =1;
        for(int i=1;i<=n;i++){
            //判断2的幂次方
            if((i &(i-1)) ==0){
                target =i;
                nums[i] =1;
            }
            nums[i]=nums[target]+nums[i-target];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = countBits(2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+"|");
        }
    }
}
