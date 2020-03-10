package m17.sdk.demo.utils;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    private static ThreadPoolExecutor sExecutor;
    public static ThreadPoolExecutor getInstance() {
        if (sExecutor == null) {
            synchronized (ThreadPool.class) {
                sExecutor = ExecutorFactory.createThreadPoolExecutor();
            }
        }
        return sExecutor;
    }
}
