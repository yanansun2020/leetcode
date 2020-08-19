package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AirCraft {
    List<PairInt> optimalUtilization_1(int maxTraelDist, List<PairInt> forwardRoutes, List<PairInt> returnRoutes){
        PriorityQueue<RouteDistance> queue = new PriorityQueue<>((d1, d2)->d1.distance-d2.distance);
        int minDifference = Integer.MAX_VALUE;
        for(PairInt forwardRoute : forwardRoutes){
            for(PairInt returnRoute: returnRoutes){
                int diatance = maxTraelDist-forwardRoute.second-returnRoute.second;
                if(diatance >= 0){
                    RouteDistance dis = new RouteDistance(forwardRoute.first, returnRoute.first, diatance);
                    queue.offer(dis);
                    minDifference = Math.min(minDifference, diatance);
                }
            }
        }
        List<PairInt> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            if(queue.peek().distance == minDifference){
                RouteDistance routeDistance =queue.poll();
                ans.add(new PairInt(routeDistance.forwardRoute, routeDistance.returnRoute));
            }else{
                break;
            }
        }
        return ans;
    }

    List<PairInt> optimalUtilization(int maxTraelDist, List<PairInt> forwardRoutes, List<PairInt> returnRoutes){
        int minDifference = Integer.MAX_VALUE;
        List<PairInt> ans = new ArrayList<>();
        for(PairInt forwardRoute : forwardRoutes){
            for(PairInt returnRoute: returnRoutes){
                int diatance = maxTraelDist-forwardRoute.second-returnRoute.second;
                if(diatance >= 0){
                    if(diatance < minDifference){
                        ans = new ArrayList<>();
                        ans.add(new PairInt(forwardRoute.first, returnRoute.first));
                        minDifference = diatance;
                    }else if(diatance == minDifference){
                        ans.add(new PairInt(forwardRoute.first, returnRoute.first));
                    }
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        List<PairInt> forwardRoutes = new ArrayList<PairInt>(){{
            add(new PairInt(1,2000));
            add(new PairInt(2,4000));
            add(new PairInt(3,6000));
        }};
        List<PairInt> returnRoutes = new ArrayList<PairInt>(){{
            add(new PairInt(1,2000));
        }};
        List<PairInt> a = optimalUtilization(7000, forwardRoutes, returnRoutes);

        List<PairInt> forwardRoutes1 = new ArrayList<PairInt>(){{
            add(new PairInt(1,3000));
            add(new PairInt(2,5000));
            add(new PairInt(3,7000));
            add(new PairInt(4,10000));
        }};
        List<PairInt> returnRoutes1 = new ArrayList<PairInt>(){{
            add(new PairInt(1,2000));
            add(new PairInt(2,3000));
            add(new PairInt(3,4000));
            add(new PairInt(4,5000));
        }};
        List<PairInt> b = optimalUtilization(10000, forwardRoutes1, returnRoutes1);
    }
}
class RouteDistance{
    int forwardRoute;
    int returnRoute;
    int distance;
    RouteDistance(){}
    RouteDistance(int forwardRoute, int returnRoute, int distance){
        this.forwardRoute = forwardRoute;
        this.returnRoute = returnRoute;
        this.distance = distance;
    }
}
