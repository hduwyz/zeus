package com.zeus.core.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class TheradTemplate<T> implements Runnable{

    @Setter
    @Getter
    private List<T> list;

    @Setter
    @Getter
    private CountDownLatch countDownLatch;

    TheradTemplate(List<T> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (!CollectionUtils.isEmpty(list)) {
            doHandle(list);
        }
        countDownLatch.countDown();
    }

    abstract public void doHandle(List<T> list);
}
