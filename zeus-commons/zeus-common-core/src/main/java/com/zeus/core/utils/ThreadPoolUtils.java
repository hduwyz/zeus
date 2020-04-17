package com.zeus.core.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolUtils<T> {

    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void execute(Runnable command) {
        if (threadPool.isShutdown()) {
            // 如果线程池关闭，那么就再创建一个线程池
            threadPool = Executors.newCachedThreadPool();
            execute(command);
        } else {
            threadPool.execute(command);
        }
    }

    /**
     * 关闭线程池
     */
    public static void shutdown() {
        if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }

    /**
     * 线程处理List，数据量大于1000以上建议手动输入每个线程处理数目
     * @param list 数据
     * @param command 任务处理器
     * @throws Exception
     *                    
     */
    public void exec(List<T> list, TheradTemplate command) throws Exception {
        exec(list, 100, command);
    }

    /**
     * 多线程处理List
     * @param list 数据
     * @param dealSize 每个线程处理数量
     * @param command 任务处理器
     * @throws Exception
     */
    public void exec(List<T> list, int dealSize, TheradTemplate command) throws Exception {
        if (!CollectionUtils.isEmpty(list)) {
            //数据总的大小
            int count = list.size();
            //每个线程数据集
            List<T> threadList = null;
            //线程池
            int runSize = (count / dealSize) + 1;
            //计数器
            CountDownLatch countDownLatch = new CountDownLatch(runSize);
            for (int i = 0; i < runSize; i++) {
                //计算每个线程执行的数据
                int startIndex = (i * dealSize);
                if ((i + 1) == runSize) {
                    int endIndex = count;
                    threadList = list.subList(startIndex, endIndex);
                } else {
                    int endIndex = (i + 1) * dealSize;
                    threadList = list.subList(startIndex, endIndex);
                }
                //执行线程任务
                command.setList(threadList);
                command.setCountDownLatch(countDownLatch);
                execute(command);
            }
            //计数
            countDownLatch.await();
            //关闭线程池
            shutdown();
        }
    }
}
