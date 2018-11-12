package club.gsjblog.springboot.freemark.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2018/11/12.
 */
public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new RealData("Hello"));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(futureTask);

        System.out.println("请求完毕，正在同步数据，请稍等。");



        //过了两分钟，查询一下数据是否同步完成
        System.out.println("真实数据：" + futureTask.get());
        executorService.shutdown();

    }
}
