package com.dudu.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/6/19 10:56 上午
 */
public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList();
        array.add("www.wdbyte.com");
        array.add("https");
// JDK Collections 创建不可变 List
        List<String> list = Collections.unmodifiableList(array);
        ImmutableList<String> strings = ImmutableList.copyOf(array);

        list.forEach(System.out::println);// www.wdbyte.com https

        list.add("未读代码"); // java.lang.UnsupportedOperationException
    }
}
