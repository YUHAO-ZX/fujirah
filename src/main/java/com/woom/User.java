package com.woom;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuhao.zx on 15-10-27.
 */
public class User {
    public Map<String,Users> u ;
    String extendRules;


    public Map<String, Users> getExtendRules() {
        Map<String,Users> rr = new HashMap<String, Users>();
        List<Users> rs = JSONArray.parseArray(extendRules, Users.class);
        for(Users rule : rs){
            rr.put(rule.getName(),rule);
        }
        return rr;
    }


}
