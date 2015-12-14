package com.woom.tools;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yuhao.zx on 15-11-30.
 */
public class EventBusTest {
    private Executor executor = Executors.newSingleThreadExecutor();
    private EventBus eventBus = new AsyncEventBus(executor);
    @PostConstruct
    public void init() {
        eventBus.register(this);
    }

    public void doSomeThing(){
        System.out.println("doSomeThing");
        eventBus.post("nihao");
    }
    public static void main(String[] args) {
        EventBusTest e = new EventBusTest();
        e.init();
        e.doSomeThing();
    }
    @Subscribe
    public void sendDepositMessage(String str){
        System.out.println(str);

    }
}
