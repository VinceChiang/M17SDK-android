package m17.sdk.demo.util;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    private static ThreadPoolExecutor sExecutor;
    public static ThreadPoolExecutor getInstance() {
        if (sExecutor == null) {
            synchronized (ThreadPool.class) {
                if (sExecutor == null) {
                    sExecutor = ExecutorFactory.createThreadPoolExecutor();
                }
            }
        }
        return sExecutor;
    }
}
