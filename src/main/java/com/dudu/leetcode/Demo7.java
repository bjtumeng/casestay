package com.dudu.leetcode;

/**
 * @Description:
 * 汉明距离
 * @author:zhaomeng
 * @date:2022/11/13 7:45 下午
 */
public class Demo7 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
