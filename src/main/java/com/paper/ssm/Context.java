package com.paper.ssm;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.data.DataService;
import com.paper.ssm.face.mqtt.Mqtt;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZengYuan
 */
public class Context {

    /** 线程池 */
    private static ExecutorService executor;

//    @Resource
//    private static MethodDataService methodDataService;

    @Resource
    private static DataService dataService;

    public static void startup() {
        initExecutor();
        Mqtt mqtt = new Mqtt();
        mqtt.run();
    }

    /**
     * 创建线程池
     */
    private static void initExecutor () {
        // 上行方向任务队列（事件上报、指令下发、指令回复、属性数据上报）
        LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>(1024);
        executor = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, taskQueue);
    }

//    public static void addTask(Task task) {
//        executor.execute(task);
//    }

    public static Data insert(Data data) {
        return dataService.insert(data);
    }

//    public static int insert(MethodData methodData) {
//        return methodDataService.insert(methodData);
//    }

}
