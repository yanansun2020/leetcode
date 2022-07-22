package oa.tesla;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestPath {

    public List<String> logestPath(FileNode root){
        List<String> res = new ArrayList<>();
        List<List<String>> paths = getPath(root);
        for (List<String> p : paths) {
            StringBuilder sb = new StringBuilder();
            for (String s : p) {
                sb.append(s);
            }
            res.add(sb.toString());
        }
        return res;
    }

    //dfs bottom up
    private List<List<String>> getPath(FileNode root) {
        List<List<String>> longestPath = new ArrayList<>();
        if (root == null) {
            return longestPath;
        }
        if (root.children == null || root.children.size() == 0) {
            List<String> tmp = new ArrayList<>();
            tmp.add(root.name);
            longestPath.add(tmp);
            return longestPath;
        }
        int longest = 0;
        for (FileNode ch : root.children) {
            List<List<String>> paths = getPath(ch);
            for (List<String> p : paths) {
                if (p.size() > longest) {
                    longest = p.size();
                    longestPath = new ArrayList<>();
                    longestPath.add(p);
                } else if (p.size() == longest && p.size() > 0) {
                    longestPath.add(p);
                }
            }
        }
        for (List<String> s : longestPath) {
            s.add(0, root.name);
        }
        return longestPath;
    }
    //bfs
    private List<String> getPath_bfs(FileNode root) {
        Queue<NodePath> queue = new LinkedList<>();
        queue.offer(new NodePath(root, root.name, 1));
        int maxSize = 0;
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            NodePath np = queue.poll();
            FileNode fn = np.node;
            if(fn.children.size() == 0) {
                if (maxSize < np.depth) {
                    res = new ArrayList<>();
                    res.add(np.path);
                    maxSize = np.depth;
                } else if (maxSize == np.depth) {
                    res.add(np.path);
                }
            } else {
                for (FileNode ch : fn.children) {
                    queue.offer(new NodePath(ch, np.path + "/" + ch.name, np.depth + 1));
                }
            }
        }
        return res;
    }



    @Test
    public void test() {
        FileNode root = new FileNode();
        root.name = "a";
        List<FileNode> list = new ArrayList<>();
        FileNode b = new FileNode("b");
        list.add(b);
        list.add(new FileNode("c"));
        list.add(new FileNode("d"));
        root.children = list;

        List<FileNode> list1 = new ArrayList<>();
        list1.add(new FileNode("e"));
        FileNode f = new FileNode("f");
        list1.add(f);
        b.children = list1;

        List<FileNode> list2 = new ArrayList<>();
        list2.add(new FileNode("g"));
        list2.add(new FileNode("h"));
        f.children= list2;

        List<String> res = logestPath(root);
        System.out.println(res);
        res = getPath_bfs(root);
        System.out.println(res);
    }
}


class NodePath{
    FileNode node;
    String path;
    int depth;
    NodePath(FileNode node, String path, int depth) {
        this.node = node;
        this.path = path;
        this.depth = depth;
    }
}

class FileNode{
    String name;
    List<FileNode> children;
    FileNode(){
        this.name = "";
        this.children = new ArrayList<>();
    }
    FileNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}
