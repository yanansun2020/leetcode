package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<WorkerBike> queue = new PriorityQueue<>(new Comparator<WorkerBike>() {
            @Override
            public int compare(WorkerBike o1, WorkerBike o2) {
                if (o1.distance == o2.distance) {
                    if (o1.workerId == o2.workerId){
                        return o1.bikeId - o2.bikeId;
                    }
                    return o1.workerId - o2.workerId;
                }
                return o1.distance - o2.distance;
            }
        });
        int[] assignWorker = new int[workers.length];
        Arrays.fill(assignWorker, -1);
        int[] assignBike = new int[bikes.length];
        Arrays.fill(assignBike, -1);
        for (int i = 0; i < workers.length; i++){
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++){
                int[] bike = bikes[j];
                WorkerBike workerBike = new WorkerBike(i, j, getDistance(worker, bike));
                queue.offer(workerBike);
            }
        }
        while (!queue.isEmpty()){
            WorkerBike wb = queue.poll();
            if (assignWorker[wb.workerId] == -1 && assignBike[wb.bikeId] == -1){
                assignWorker[wb.workerId] = wb.bikeId;
                assignBike[wb.bikeId] = wb.workerId;
            }
        }
        return assignWorker;
    }
    private int getDistance(int[] worker,  int[] bike){
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    @Test
    public void test(){
        int[][] worker = new int[][]{{0,0},{1,1},{2,0}};
        int[][] bike = new int[][]{{1,0},{2,2},{2,1}};
        int[] ans = assignBikes(worker, bike);
    }
}
class WorkerBike{
    int workerId;
    int bikeId;
    int distance;
    WorkerBike(){}
    WorkerBike(int workerId, int bikeId, int distance){
        this.workerId = workerId;
        this.bikeId = bikeId;
        this.distance = distance;
    }
}
