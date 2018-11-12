package club.gsjblog.springboot.freemark.future;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2018/11/12.
 */
public class RealData implements Callable<String> {

    private String result;

    public RealData(String result) {
        this.result = result;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        // 构造真实的数据
        StringBuffer bf = new StringBuffer();
        bf.append(result);

        Thread.sleep(50000);

        //返回处理完成的数据
        return bf.toString();
    }
}
