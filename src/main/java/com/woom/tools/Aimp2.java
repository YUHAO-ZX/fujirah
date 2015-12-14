package com.woom.tools;

/**
 * Created by yuhao.zx on 15-10-23.
 */
public class Aimp2 extends DefaultA implements A {

    public void doSomething(){
        super.doSomething();
        System.out.println("good");
    }

    public static void main(String[] args) {
        A a = new Aimp2();
        a.doSomething();
    }
}
