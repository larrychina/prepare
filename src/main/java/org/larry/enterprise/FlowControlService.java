package org.larry.enterprise;


import org.larry.util.ConvertUtils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 流量控制
 */
public class FlowControlService {

    ConvertUtils redisService ;
    public List<String> batchConvert(List<String> longUrl){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 0,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        final String redisKey = "test";
        executor.execute(new Runnable() {
            @Override
            public void run() {
               try {
                   // 1，获取当前活跃连接数
                   int activeCount = 1 ; // UrlConvertUtil.incrConnCount(redisClient,redisKey);
                   // 2，获取开关配置的数量
                   int limitCount = 50; // 真实业务从配置中获取;
                   if(activeCount < limitCount ) {
                       // 1,incr activeCount+1
                       ConvertUtils.incrTaskCount(redisService,redisKey);
                       // 2,再次判断，双重检查减少并发带来的问题
                       if(activeCount <= limitCount){
                           // sendData
                           dealData();
                       } else {
                           // 1，decount
                           ConvertUtils.decrTaskCount(redisService,redisKey);
                           // 2，加入 随机等待，防止不停重入浪费资源
                           Thread.sleep(new Random().nextInt(1000));
                           // 3，加入到队列中
                           executor.execute(this);
                       }
                   }
               }catch (Exception e){
                    // 日志输出1
                    // 数量减一，防止死循环，不可缺少
                   ConvertUtils.decrTaskCount(redisService,redisKey);
               }
            }
        });

        return null ;
    }

    private void dealData(){

    }
}
