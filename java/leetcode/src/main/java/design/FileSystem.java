package design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }
    public List<String> ls(String path) {
        TrieNode node = root;
        String[] paths = path.split("/");
        List<String> ans = new ArrayList<>();
        if(paths.length == 0){
            for(Map.Entry<String, TrieNode> entry: node.children.entrySet()){
                ans.add(entry.getKey());
            }
            Collections.sort(ans);
            return ans;
        }
        for(int i=0; i<paths.length; i++){
            String p = paths[i];
            if(p.length() == 0){
                continue;
            }
            TrieNode tmp = node.getByPath(p);
            if(tmp == null) {
                return ans;
            }
            node = tmp;
        }
        if(node.isFile){
            ans.add(paths[paths.length-1]);
            return ans;
        }
        for(Map.Entry<String, TrieNode> entry: node.children.entrySet()){
            ans.add(entry.getKey());
        }
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        TrieNode node = root;
        String[] paths = path.split("/");
        for(String p : paths){
            if(p == null || p.length() == 0){
                continue;
            }
            TrieNode tmp = node.getByPath(p);
            if(tmp == null){
                tmp = new TrieNode();
                node.insertNode(p, tmp);
            }
            node = tmp;
        }
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = root;
        String[] paths = filePath.split("/");
        for(String p : paths){
            if(p.length() == 0){
                continue;
            }
            TrieNode tmp = node.getByPath(p);
            if(tmp == null){
                tmp = new TrieNode();
                node.insertNode(p, tmp);
            }
            node = tmp;
        }
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        TrieNode node = root;
        String[] paths = filePath.split("/");
        for(String p : paths){
            if(p.length() == 0){
                continue;
            }
            TrieNode tmp = node.getByPath(p);
            if(tmp == null){
                tmp = new TrieNode();
                node.insertNode(p, tmp);
            }
            node = tmp;
        }
        if(node.isFile){
            return node.content;
        }
        return "";
    }
    @Test
    public void test(){
        FileSystem fileSystem = new FileSystem();
        List<String> a = fileSystem.ls("/");
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        List<String> b = fileSystem.ls("/a");
        String c = fileSystem.readContentFromFile("/a/b/c/d");
    }
}
class TrieNode{
    boolean isFile;
    String content ="";
    Map<String, TrieNode> children = new HashMap<>();
    TrieNode(){}
//    TrieNode(String root){
//        children.put(root, new TrieNode());
//    }
    TrieNode getByPath(String path){
        if(children.containsKey(path)){
            return children.get(path);
        }
        return null;
    }
    void insertNode(String path, TrieNode node){
        children.put(path, node);
    }
}
