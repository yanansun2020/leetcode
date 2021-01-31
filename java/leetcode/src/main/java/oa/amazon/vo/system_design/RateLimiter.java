package oa.amazon.vo.system_design;

/**
 * Write a rate limiter function. 问了一下requirement。
 * 其实应该用最简单的sliding window去做，
 * 结果前两天看system design学到个token bucket，想要炫技，
 * 结果对两种模式没有深刻的理解，到最后自己都晕了。
 * 失败。。。现在我理解两者的区别在于如果一瞬间来了大量的request并且被rate limit了，
 * token bucket后面的token会缓慢释放，而sliding window会等到一个window的周期过去以后瞬间释放所有quota。
 *
 * 这种区别事前没有仔细想过的话面试可能想不出来。
 */
public class RateLimiter {
}
