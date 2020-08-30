package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> lst;
    int position;
    public NestedIterator(List<NestedInteger> nestedList) {
        position = 0;
        lst = new ArrayList<>();
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        Integer ans = lst.get(position);
        position++;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return position < lst.size();
    }
    private void flatten(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                lst.add(nestedInteger.getInteger());
            }else{
                flatten(nestedInteger.getList());
            }
        }
    }
}
