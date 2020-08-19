package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClosestPoint {
    public long closestSquaredDistance(int numRobots, List<Integer> positionX, List<Integer> positionY){
        Point[] p = new Point[numRobots];
        for(int i =0; i<numRobots; i++){
            p[i] = new Point(positionX.get(i), positionY.get(i));
        }
        return getClosestPoint(p, 0, numRobots-1);
    }

    private long getClosestPoint(Point[] p, int start, int end){
        if (end -start+1 <= 3)
            return bruteForce(p, start, end);
        int mid = (start+end)/2;
        Point midPoint = p[mid];
        long dl = getClosestPoint(p, start, mid);
        long dr = getClosestPoint(p,mid+1, end );
        long d = Math.min(dl, dr);
        List<Point> strip = new ArrayList<>();
        for(int i = start; i<= end; i++){
            if(Math.abs(p[i].x - midPoint.x) < d){
                strip.add(p[i]);
            }
        }
        return Math.min(d, stripClosest(strip, d));
    }

    private long stripClosest(List<Point> strip, long d) {
        long minValue = d;
        strip.sort((p1, p2)->p1.y-p2.y);
        for(int i =0; i <strip.size(); i++){
            int j = i +1;
            while(j < strip.size() && strip.get(j).y -strip.get(i).y< minValue){
                minValue = dist(strip.get(i), strip.get(j));
                j += 1;
            }
        }
        return minValue;
    }
    private long dist(Point p1, Point p2){
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    long bruteForce(Point P[], int start, int end){
        long min = Long.MAX_VALUE;
        for (int i = start; i <= end; ++i)
            for (int j = i+1; j <= end; ++j)
                if (dist(P[i], P[j]) < min)
                    min = dist(P[i], P[j]);
        return min;
    }

    @Test
    public void test(){
        List<Integer> x = new ArrayList<Integer>(){
            {
                add(0);
                add(1);
                add(2);
                add(3);
            }
        };
        List<Integer> y = new ArrayList<Integer>(){
            {
                add(0);
                add(1);
                add(4);
                add(3);
            }
        };
        long a = closestSquaredDistance(4, x, y);
    }
}
class Point{
    Integer x;
    Integer y;
    Point(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
}
