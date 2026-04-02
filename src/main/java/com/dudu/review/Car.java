package com.dudu.review;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/6/4 5:12 下午
 */
public class Car {
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name,Integer code) {
        this.code = code;
        this.name = name;
    }
}
