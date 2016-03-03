package tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuhao.zx on 16-2-28.
 */
public class Test1 {
    public static Jedis jedis = new Jedis("localhost");
    public static void main(String[] args) {
        Integer type = Integer.valueOf(args[0]);
        System.out.println("start");
        switch (type){
            case 1:testMap();break;
            case 2:testList();break;
            case 3:testSet();break;
            case 4:testTime();break;
            case 5:testPool();break;
            case 6:;break;
            case 7:;break;
            case 8:;break;
            case 9:;break;
            case 10:;break;
            case 11:;break;
            default:break;
        }
    }

    public static void testMap(){
        Map<String,String> userInfo = new HashMap<String, String>();
        userInfo.put("name","zhangxin");
        userInfo.put("age","100");
        userInfo.put("qq","569485785");
        jedis.hmset("user", userInfo);
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        for(String ele : rsmap){
            System.out.println(ele);
        }

    }
    public static void testList(){
        jedis.del("mylist");
        jedis.lpush("mylist", "spring");
        jedis.lpush("mylist", "stuts");
        jedis.lpush("mylist","spring");
        System.out.println(jedis.lrange("mylist",0,-1));
    }
    public static void testSet(){
        jedis.del("user");
        jedis.sadd("user","ele1");
        jedis.sadd("user","ele1");
        jedis.sadd("user","ele2");
        jedis.sadd("user","ele3");
        jedis.sadd("user","ele4");
        System.out.println(jedis.smembers("user"));
        System.out.println(jedis.scard("user"));
    }
    public static void testTime(){
        Long time = System.currentTimeMillis();
        jedis.del("time");
        for(int i= 0 ;i< 10000;i++){
            jedis.lpush("time","time"+i);
        }
        System.out.println("cost="+(System.currentTimeMillis()-time));
        System.out.println(jedis.lrange("time",0,-1));
        jedis.del("time");
    }
    public static void testPool(){
        Jedis f = RedisUtils.getJedis();
        for(int i = 0 ;i<= 10;i++){
            Thread d = new Thread(new Runnable() {
                public void run() {
                    Jedis f = RedisUtils.getJedis();
                    Long time = System.currentTimeMillis();
                    f.del("time");
                    for(int i= 0 ;i< 500;i++){
                        f.lpush("time","time"+i);
                    }
                    System.out.println(Thread.currentThread().getId()+"cost="+(System.currentTimeMillis()-time));
                    System.out.println(jedis.lrange("time",0,-1));
                }
            });
            d.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.del("time");
    }
}
