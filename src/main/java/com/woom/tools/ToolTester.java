package com.woom.tools;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by yuhao.zx on 15-1-2.
 *
 * 单元测试中如果主线程完成了，那么会将其他线程杀死，不会等待其执行
 */

@ContextConfiguration(locations = { "classpath*:test/groovy.xml"})
public class ToolTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    GroovyTest groovyTest;
    @Test
    public void test() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
        }
    }



}
