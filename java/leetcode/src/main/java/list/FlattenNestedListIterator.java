package list;

import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
    public NestedIterator(List<NestedInteger> nestedList) {
    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}