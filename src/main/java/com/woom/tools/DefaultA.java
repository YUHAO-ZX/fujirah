package com.woom.tools;

import com.alibaba.fastjson.JSONArray;
import com.woom.User;
import com.woom.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yuhao.zx on 15-10-23.
 */
public class DefaultA implements A{
    @Override
    public void doSomething() {
        System.out.println("hello");
    }

    public static void main(String[] args) throws ParseException {
        String show = "2015-11-04 00:00:00";
        String start = "2015-11-07 00:00:00";
        String end = "2015-11-08 00:00:00";

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
        Date showD = s.parse(show);
        Date startD = s.parse(start);
        Date endD = s.parse(end);
        System.out.println(showD.getTime()+":"+startD.getTime()+":"+endD.getTime());

        List<Users> users = new ArrayList<Users>();
        Users u1 = new Users();
        Users u2 = new Users();
        u1.setCode("2323");
        u2.setCode("3424");
        u1.setName("sdfsf");
        u2.setName("dfsdd");
        users.add(u1);
        users.add(u2);
        String ans = JSONArray.toJSONString(users);
        System.out.println(ans);
    }
}
