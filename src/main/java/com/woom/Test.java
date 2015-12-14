package com.woom;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.TeMinisiteAddTo;
import com.taobao.api.request.AlibabaMeilihuiActivityAddRequest;
import com.taobao.api.response.AlibabaMeilihuiActivityAddResponse;
import com.woom.tools.GroovyContiner;
import com.woom.tools.GroovyTest;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public class Test {
    public static String remove0156OfAliPayId(String accountNO){

        if(accountNO != null && accountNO.endsWith("0156")){
            return accountNO.substring(0,accountNO.length()-4);
        }
        return  accountNO;

    }

    public static void main(String[] args) throws ParseException {
        final Long a = 0L;
        System.out.println(a == 0);

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath*:/test/groovy.xml");
//        GroovyContiner foo = context.getBean(GroovyContiner.class);
//        URL str = Test.class.getProtectionDomain().getCodeSource().getLocation();
//        System.out.println(str);
//        System.out.println(foo.getGroovyTest().getMessage());
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            System.out.println("输入任意键");
//            in.next();
//            System.out.println(foo.getGroovyTest().getMessage());
//        }


//        try {
//            mkMistake();
//        }catch (Exception e){
//            StackTraceElement[] elements =  e.getStackTrace();
//            System.out.println(e.getStackTrace());
//        }
//        System.out.println(String.valueOf(null));
//        String show = "2015-12-01 10:00:00";
//        String start = "2015-12-04 00:00:00";
//        String end = "2015-12-20 00:00:00";
//
//        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
//        Date showD = s.parse(show);
//        Date startD = s.parse(start);
//        Date endD = s.parse(end);
//        System.out.println(showD.getTime()+":"+startD.getTime()+":"+endD.getTime());


//        String myName = "宇晧";
//        System.out.println(myName);
//        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.tbsandbox.com/router/rest", "1023258879", "sandbox59274f053a57db2431dc29f13");
//        AlibabaMeilihuiActivityAddRequest amacr = new AlibabaMeilihuiActivityAddRequest();
//        TeMinisiteAddTo eventDto = new TeMinisiteAddTo();
//        eventDto.setBizType("MEI_LI_HUI");
//        eventDto.setCategoryId(100L);
//        eventDto.setName("test");
//        amacr.setParamTeMinisiteAddTO(eventDto);
//        AlibabaMeilihuiActivityAddResponse rsp = null;
//        try {
//             rsp = client.execute(amacr);
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//        System.out.println(rsp.getResult());


//        TestEnum t = TestEnum.T;
//        t.setStr("m");
//        System.out.println(t.getStr());
//
//        TestEnum t2 = TestEnum.T;
//        System.out.println(t2.getStr());

//        Users u1 = new Users();
//        u1.setCode("df1");
//        Users u2 = new Users();
//        u2.setName("hehe");
//        u2.setCode("df2");
//        Users u3 = new Users();
//        u2.setName("haha");
//        u3.setCode("df2");
//
//        new String("dfsf").intern();
//        ImmutableMap<Long,Users> oneMap=ImmutableMap.of(new Long(1),u1,Long.valueOf("2"),u2);
//        ImmutableMap<Long,Users> twoMap=ImmutableMap.of(new Long(2),u3,new Long(3),u3);
//        MapDifference<Long,Users> diffHadle= Maps.difference(oneMap, twoMap);
//        Map<Long,Users> commonMap=diffHadle.entriesInCommon();//{"key2",2},若无共同Entry，则返回长度为0的Map
//        Map<Long,Users> diffOnLeft=diffHadle.entriesOnlyOnLeft();//返回左边的Map中不同或者特有的元素
//        Map<Long,Users> diffOnRight=diffHadle.entriesOnlyOnRight();//返回右边的Map中不同或者特有的元素
//        for(Long key:commonMap.keySet()){
//            System.out.println(commonMap.get(key).getName());
//
//        }
//
//        Long a = new Long(1);
//        Long b = new Long(1);
//
//        System.out.println(a==b);//false
//        System.out.println(a.equals(b));//true
//        String str = "[{\"name\": \"1\"}]";
////        String str = "[{\"a\",\"b\",\"c\"}]";
//        System.out.println("''''''");
//        System.out.println(str);
//        User u = new User();
//        u.extendRules="[{\"name\": \"1\"}]";
//        Map<String,Users> rs = u.getExtendRules();
//
//        System.out.println("finish");
    }

    private static void mkMistake(){
        throw new NumberFormatException();
    }
}
