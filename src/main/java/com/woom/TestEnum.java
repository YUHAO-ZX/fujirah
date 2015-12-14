package com.woom;

/**
 * Created by yuhao.zx on 15-11-1.
 */
public enum TestEnum {
    T("TEST:");
    private String str;
    TestEnum(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
