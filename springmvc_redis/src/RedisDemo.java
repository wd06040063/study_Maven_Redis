import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * @author Wangdong
 * @date 2019/11/28 - 下午7:19
 */
public class RedisDemo {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        jedis.auth("root");
        System.out.printf(jedis.ping());

    }
    @Test
    public void t1(){
        //get connect
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
        jedis.set("strName","String name");
        String strName = jedis.get("strName");
        System.out.printf("Redis data:"+strName);
        jedis.close();
    }
    @Test
    public void t2(){
        //get connect redis
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
        String key = "applicationName";
        if(jedis.exists(key)){
            String result = jedis.get(key);
            System.out.printf("Redis database check result:"+result);
        }else {
            //databae check
            String result  = "wechat";
            jedis.set(key,result);
            System.out.printf("Mysql database check result:"+result);
        }
    jedis.close();
    }


}
