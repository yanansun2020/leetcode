package oa.airbnb;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class FileSystem {
    FileNode root;
    public FileSystem() {
        root = new FileNode();
        root.subs.put("", new FileNode());
    }

    public boolean createPath(String path, int value) {
        String[] paths = path.split("/");
        FileNode node = root;
        if (create(node,paths, 0, value)) {
            return true;
        }
        return false;
    }

    public int get(String path) {
        FileNode node = root;
        return getValue(node, path.split("/"), 0);
    }

    private int getValue(FileNode node, String[] paths, int index) {
        if (index == paths.length - 1) {
            if (node.subs.containsKey(paths[index])) {
                return node.value;
            } else {
                return -1;
            }
        }
        if (!node.subs.containsKey(paths[index])) {
            return -1;
        }
        return getValue(node.subs.get(paths[index]), paths, index + 1);
    }

    private boolean create(FileNode node, String[] paths, int index, int value) {
        if(index == paths.length - 1) {
            //path already exist;
            if (node.subs.containsKey(paths[index])) {
                return false;
            }
            node.subs.put(paths[index], new FileNode(value));
            //node.value = value;
            return true;
        }

        String p = paths[index];
        //middle path does not exist
        if (!node.subs.containsKey(p)) {
            return false;
        } else {
            return create(node.subs.get(p), paths, index + 1, value);
        }
    }


    @Test
    public void test() {
        createPath("/a", 1);
        createPath("/b", 2);
        System.out.println(get("/a"));
    }
}

class FileNode{
    //String name;
    Map<String, FileNode> subs;
    int value;
    FileNode(){
        this.subs = new HashMap<>();
        this.value = -1;
        //this.subs.put("", new FileNode());
    }
    FileNode(int value) {
        //this.name = name;
        this.subs = new HashMap<>();
        this.value = value;
    }
}
