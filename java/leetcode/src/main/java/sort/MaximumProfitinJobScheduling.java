package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProfitinJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(i, startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs, ((o1, o2) -> o1.endTime - o2.endTime));
        for (int i = 1; i < startTime.length; i++){
            Job job = jobs.get(i);
            for (int j = 0; j < i; j++) {
                if (!isOverlap(jobs.get(j), job)){
                    if (jobs.get(j).profit + profit[job.jobId] > job.profit){
                        job.profit = jobs.get(j).profit + profit[job.jobId];
                    }
                }
            }
        }
        int maxProfit = 0;
        for (Job job : jobs){
            maxProfit = Math.max(job.profit, maxProfit);
        }
        return maxProfit;
    }
    private boolean isOverlap(Job job1, Job job2){
        return job2.startTime >= job1.startTime && job2.startTime < job1.endTime;
    }
    @Test
    public void test() {
        int[] startTime = new int[]{1, 2, 3, 3};
        int[] endTime = new int[]{3, 4, 5, 6};
        int[] profit = new int[]{50, 10, 40, 70};
        int ans = jobScheduling(startTime, endTime, profit);
    }
}
class Job{
    int jobId;
    int startTime;
    int endTime;
    int profit;
    Job(){}
    Job(int jobId, int startTime, int endTime, int profit){
        this.jobId = jobId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
