package com.ruoyi.common.utils;

/**
 * id生成单例
 * 确保调用的id生成器是同一个对象
 */
public class IdGenerator {
    private SnowflakeIdWorker recordIdWorker;

    private static volatile IdGenerator safeSingleton;//防止指令重排

    /**
     * 不同的机器上使用不同的workerid和datacenterid
     */
    private IdGenerator() {
        recordIdWorker = new SnowflakeIdWorker(1, 1);
    }

    public SnowflakeIdWorker getRecordIdWorker(){
        return recordIdWorker;
    }

    public static IdGenerator getInstance(){
        if(safeSingleton==null){
            synchronized (IdGenerator.class){
                if(safeSingleton==null){//双重检测
                    safeSingleton = new IdGenerator();
                }
            }
        }
        return safeSingleton;
    }
}
