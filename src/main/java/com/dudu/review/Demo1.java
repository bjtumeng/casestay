package com.dudu.review;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/3/6 3:30 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Car> CarArrayList = new ArrayList<>(3);
        CarArrayList.add(new Car("version2", 12));
        CarArrayList.add(new Car("version1", 18));
        CarArrayList.add(new Car("version3", 6));
        Map<String,Integer> map1 = CarArrayList.stream().collect(
// 生成的 map 集合中只有一个键值对：{version=6.28}
                Collectors.toMap(Car ::getName, Car::getCode, (v1, v2) -> v1+v2));

        System.out.println(map1.toString());
    }

    public static List<Integer> test(int[] num){
        List<Integer> list = new ArrayList<>();
        int count =1;
        for (int i=0;i<num.length;i++){
            int start = num[i];
            if (i<num.length-1 && start == num[i+1]){
                count++;
            }else{
                list.add(count);
                list.add(start);
                count = 1;
            }
        }
        return list;
    }
}
