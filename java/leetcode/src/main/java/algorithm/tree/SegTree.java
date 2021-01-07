package algorithm.tree;

public class SegTree {
    SegTreeNode root;
    public SegTree(int n) {
        root = new SegTreeNode(0, n);
    }

    public int getRangeQuery(int start, int end) {
        return getRangeQuery(start, end, root);
    }

    private int getRangeQuery(int start, int end, SegTreeNode curr) {
        if (curr.start == start && curr.end == end) {
            return curr.val;
        }

        int nodeStart = curr.start;
        int nodeEnd = curr.end;
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (mid >= end) {
            return getRangeQuery(start, end, curr.left);
        } else if (mid + 1 <= start) {
            return getRangeQuery(start, end, curr.right);
        } else {
            return Math.min(getRangeQuery(start, mid, curr.left), getRangeQuery(mid + 1, end, curr.right));
        }

    }

    public void update(int point) {
        update(point, root);
    }

    private void update(int point, SegTreeNode curr) {
        if (curr.start == curr.end) {
            curr.val = Integer.MAX_VALUE;
            return;
        }

        int nodeStart = curr.start;
        int nodeEnd = curr.end;
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (point <= mid) {
            update(point, curr.left);
            curr.val = Math.min(curr.left.val, curr.right.val);
        } else {
            update(point, curr.right);
            curr.val = Math.min(curr.left.val, curr.right.val);
        }

    }
}

class SegTreeNode {
    SegTreeNode left;
    SegTreeNode right;
    int val;
    int start;
    int end;
    SegTreeNode(){}
    public SegTreeNode(int start, int end) {
        this.start = start;
        this.end = end;

        if (start == end) {
            val = start;
        } else {
            int mid = start + (end - start) / 2;
            this.left = new SegTreeNode(start, mid);
            this.right = new SegTreeNode(mid + 1, end);
            val = start;
        }
    }
}
