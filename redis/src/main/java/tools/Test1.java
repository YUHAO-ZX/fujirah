package tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by yuhao.zx on 16-2-28.
 */
public class Test1 {
    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public static void main(String[] args) {
        System.out.println("start");
        Jedis jedis = new Jedis("localhost");//查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
        jedis.set("key","value1");
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
    }
}
