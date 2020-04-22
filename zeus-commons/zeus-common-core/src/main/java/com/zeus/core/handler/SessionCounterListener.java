package com.zeus.core.handler;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionCounterListener implements HttpSessionListener {

    public static AtomicInteger userCount = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
       userCount.getAndIncrement();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userCount.getAndDecrement();
    }
}
