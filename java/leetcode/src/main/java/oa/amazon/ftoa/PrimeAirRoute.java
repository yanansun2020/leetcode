package oa.amazon.ftoa;

import java.util.ArrayList;
import java.util.List;

public class PrimeAirRoute {
    public List<PairInt> getOptimizedUtilize(int maxTravelDist, List<PairInt> forwardRouteList, List<PairInt> returnRouteList){
        List<PairInt> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<forwardRouteList.size();i++){
            for(int j=0;j<forwardRouteList.size();j++){
                int sum=forwardRouteList.get(i).second +returnRouteList.get(i).second;
                if(sum<=maxTravelDist){
                    if(sum > max){
                        max = sum;
                        result=new ArrayList<>();
                        result.add(new PairInt(forwardRouteList.get(i).first, returnRouteList.get(i).first));
                    }else{
                        result.add(new PairInt(forwardRouteList.get(i).first, returnRouteList.get(i).first));
                    }
                }
            }
        }
        return result;
    }
}
class PairInt{
    int first;
    int second;
    public PairInt(int first,int second) {
        this.first = first;
        this.second = second;
    }
}
