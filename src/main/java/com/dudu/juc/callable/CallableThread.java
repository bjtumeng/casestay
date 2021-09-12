package com.dudu.juc.callable;

import java.util.concurrent.Callable;

/**
 * @Description:
 * 实现Callable接口
 * @author:zhaomeng
 * @date:2021/9/12 5:24 下午
 */
public class CallableThread implements Callable {
    @Override
    public Integer call() throws Exception {
        return 200;
    }
}
