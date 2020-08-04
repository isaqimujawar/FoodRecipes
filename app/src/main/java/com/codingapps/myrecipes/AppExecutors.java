package com.codingapps.myrecipes;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {
//Executors are responsible for executing runnable tasks
    private static AppExecutors instance;
    public static AppExecutors getInstance(){
        if (instance == null) {
            instance = new AppExecutors();
        }
        return instance;
    }

    private AppExecutors() {
    }

    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO(){
        return mNetworkIO;
    }
}
