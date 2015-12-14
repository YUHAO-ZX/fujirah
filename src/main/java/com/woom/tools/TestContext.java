package com.woom.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yuhao.zx on 15-9-23.
 */
public class TestContext {
    public static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:test/effective.xml");
    public static Object getBean(String name){
        return ac.getBean(name);
    }
}
