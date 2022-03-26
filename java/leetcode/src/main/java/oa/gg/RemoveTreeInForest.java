package oa.gg;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-794769-1-1.html
 * You are given a forest in the form of a list of nodes. Every node has a name(arbitrary string) and a parent index
 * parent index is the index of the parent node in the list
 * for a root node, the parent index points to the nodes own position in the list nodes can generally occur in any order, but children must occur after thier parent
 * e.g.
 * 0        1         2         3       4      5       6        7 （these are just helper index for the following arrays）
 * [A,0],  [B,‍‌‍‌‌‌‌‌‌‌‍‌‌‌‍‌‍‍‌‌ 0], [C,1], [D,0], [E,4],[F,4],[G,5],[H,3]
 * write a function that takes a forest and an index of node to remove and returns a new forest with same structure as input, but with the one node removed.
 *
 * idea:
 * 每个node 只有指向parent 的link，所以一个node 删除的话，只用考虑他的孩子， 假如要删除的是x
 * 用一个小一个size 的 array 去装result， 然后我们遍历input，  如果 parent index == delete index，
 * 直接把parent index 改成 当前res array的index，  如果parent index 比x 大， parent index 就减一，
 */
public class RemoveTreeInForest {
    public List<Forst> removeTree(Forst[] forest) {
        return new ArrayList<>();
    }
}

class Forst{
    String tree;
    int parent;
}
