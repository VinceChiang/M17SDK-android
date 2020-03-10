package m17.sdk.demo.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorFactory {
    static ThreadPoolExecutor createThreadPoolExecutor() {
        int N = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                N,
                N * 2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>()
        );
        executor.allowCoreThreadTimeOut(true);
        executor.prestartCoreThread();
        return executor;
    }
}
