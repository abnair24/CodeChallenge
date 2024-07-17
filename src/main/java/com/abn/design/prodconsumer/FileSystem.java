package com.abn.design.prodconsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

    private class TrieNode {
        public Map<String, TrieNode> children = new HashMap<>();
        public boolean isFile = false;
        public StringBuilder content = new StringBuilder();
    }

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public List<String> ls(String path) {

        TrieNode node = traverse(path);
        if(node.isFile) {
            return Arrays.asList(path.substring(path.lastIndexOf("/") + 1));
        } else {
            List<String> result = new ArrayList<>(node.children.keySet());
            Collections.sort(result);
            return result;
        }
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {

        TrieNode node = traverse(filePath);
        if(node.isFile) {
            return node.content.toString();
        } else {
            return "";
        }
    }

    private TrieNode traverse(String path) {

        TrieNode current = root;
        if(path.equals("/")) {
            return root;
        }
        String[] paths = path.split("/");
        for(String p : paths) {
            if (p.isEmpty()) {
                continue;
            }
            current.children.putIfAbsent(p, new TrieNode());
            current = current.children.get(p);
        }
        return current;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        fs.ls("/");
        fs.readContentFromFile("/a/b/c/d");
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
