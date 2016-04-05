package com.woom;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.joda.time.DateTime;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by yuhao.zx on 15-9-14.
 */
 class NULL {

    public static void haha(){
        System.out.println("haha");
    }
    public static void main(String[] args) {
        ((NULL)null).haha();
    }

}
public class Test {
    public static String remove0156OfAliPayId(String accountNO){

        if(accountNO != null && accountNO.endsWith("0156")){
            return accountNO.substring(0,accountNO.length()-4);
        }
        return  accountNO;

    }

    public static Double keep2point(Double d){
        if(null == d){
            return null;
        }
        BigDecimal b   =   new   BigDecimal(d);
        return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void fileScan(File f){
        boolean isD = f.isDirectory();
        if(isD){
            for(File son :f.listFiles()){
                fileScan(son);
            }
        }else{
            String fileName = f.getName();
            if(fileName.endsWith(".jpeg")||fileName.endsWith(".png")||fileName.endsWith(".jpeg")||fileName.endsWith(".jpg")){
                f.renameTo(new File("D://pics",f.getName()));
            }
        }
    }
    @Subscribe
    public void test(Integer msId){
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("msIs="+msId+":"+Thread.currentThread().getId()+","+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws ParseException, InterruptedException {
        fileScan(new File("D:\\test\\image2"));
//        fileScan(new File("D://pics"));
//        System.out.println("asdfas".split(",")[0]);
//        Map<String,Long> supp = new HashMap<String, Long>();
//        supp.put("m1",4L);
//        supp.put("m3",4L);
//        supp.put("m2",4L);
//
//
//
//        String  supName = "";
//        Map<String,Integer> repeat = new HashMap<String, Integer>();
//        for(int i = 1 ; i <= 5 ; i++){
//            boolean isFind = false;
//            Long maxValue = -1L;
//            for(String ele : supp.keySet()){
//                Long value = supp.get(ele);
//                if(value > maxValue && repeat.get(ele) == null){
//                    isFind = true;
//                    maxValue = value;
//                    supName = ele;
//                    repeat.put(ele,1);
//                }
//            }
//            if(!isFind)
//                break;
//            System.out.println("supplier_name_"+i+"--"+supName);
//            System.out.println("supplier_items_"+i+"--"+maxValue);
//        }

//        System.out.println(0L/100);
//        System.out.println("方漫".getBytes().length);
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DAY_OF_MONTH,-1);
//        c.getTime();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String s = "2016-01-21 00:11:44";
//        if(sdf.format(sdf.parse(s)).equals(sdf.format(new Date()))){
//            System.out.println("ok");
//        }else{
//            System.out.println("no");
//        }
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 6; i++) {
//            final int index = i;
//            System.out.println("task: " + (i+1));
//            Runnable run = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("thread start" + index);
//                    try {
//                        Thread.sleep(Long.MAX_VALUE);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("thread end" + index);
//                }
//            };
//            service.execute(run);
//        }
//        Executor executor = Executors.newFixedThreadPool(20);
//        EventBus eventBus = new AsyncEventBus(executor);
//        eventBus.register(new Test());
//        System.out.println(":"+Thread.currentThread().getId()+","+Thread.currentThread().getName());
//        for(int i=0;i<1000;i++){
//            eventBus.post(i);
//        }


//        Double d = 199741344.1541235d;
//        System.out.println(Math.round(d));
//        System.out.println("fasd".equals(null));
//        Date nowDate = new DateTime().plusHours(24).toDate();
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
//        System.out.println(sd.format(nowDate));


//        BigDecimal b = new BigDecimal(123.3);
//        BigDecimal c = new BigDecimal(100);
//        System.out.println(b.divide(c).doubleValue());
//        System.out.println(Long.valueOf("0.02"));
//        System.out.println(0.05 + 0.01);
//        System.out.println(1.0 - 0.42);
//        System.out.println(4.015 * 100);
//        System.out.println(123.3 / 100);
//        String[] strs = "sdf:".split(":");
//        System.out.println(strs[0]);
//        System.out.println(strs[1]);
//        System.out.println(keep2point(23123.12312312));
//        SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DAY_OF_MONTH,-1);
//        System.out.println(s.format(c.getTime()));
//        BigDecimal bd = new BigDecimal(4596);
//        bd.divide(new BigDecimal(100));
//        System.out.println(bd.movePointLeft(2).doubleValue());
//        LoadingCache<Long, String> cahceBuilder = CacheBuilder
//                .newBuilder()
//                .refreshAfterWrite(60, TimeUnit.SECONDS)
//                .build(new CacheLoader<Long, String>(){
//                    @Override
//                    public String load(Long activityId) throws Exception {
//                        return null;
//                    }
//                });
//        try {
//            String a = cahceBuilder.get(1L);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (Throwable t){
//            t.printStackTrace();
//        }
//        Long a = 1000L;
//        Long b = a ;
//        a = 999L;
//        System.out.println(b);
//        final Long a = 0L;
//        System.out.println(a == 0);

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
