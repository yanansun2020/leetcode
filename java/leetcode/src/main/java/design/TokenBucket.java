package design;

/**
 * A rate limit algorithm
 */
public class TokenBucket {
    private long maxBucketSize;
    private long refillRate;
    private double currentBucketSize;
    private long lastFillTimestamp;
    public TokenBucket(long maxBucketSize, long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentBucketSize = maxBucketSize;
        lastFillTimestamp = System.nanoTime();
    }
    public synchronized boolean allowRequest(int tokens){
        refill();
        if (currentBucketSize > tokens) {
            currentBucketSize -= tokens;
            return true;
        }
        return false;

    }
    private void refill(){
        long now = System.nanoTime();
        double tokenAdd = (now - lastFillTimestamp) * refillRate;
        currentBucketSize = Math.min(currentBucketSize + tokenAdd, maxBucketSize);
        lastFillTimestamp = now;
    }
}
