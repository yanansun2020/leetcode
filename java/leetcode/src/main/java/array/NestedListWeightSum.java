package array;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return getDepthSum(nestedList, 1);
    }
    int getDepthSum(List<NestedInteger> nestedList, int depth){
        int sumValue = 0;
        for(NestedInteger nestedInteger : nestedList){
            Integer tmpInt = nestedInteger.getInteger();
            sumValue += tmpInt == null ? 0: tmpInt * depth;
            List<NestedInteger> lst = nestedInteger.getList();
            sumValue += getDepthSum(lst, depth + 1);
        }
        return sumValue;
    }
}
