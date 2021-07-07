package oa.gg;
/**
 * leetcode 359
 * 利口散无酒 用hashmap解出来了结果粗心有个case少写了个print，被提醒才发现。follow up问如果log有无线多怎么办。
 * 楼主直到最后才明白问题的关键是可以把10秒之前的key time都删了，只存10秒内的东西，写了个遍历的O n solution没时间优化了，提到了用ordereddict 来keep track order。
 */
public class LoggerRateLimiter {
    
}
