package my.practice.ds;

import java.util.*;

/**
 * Created by kmishra on 8/17/2016.
 */
public class Trie {

    public static class Node {
        private char c;
        private Map<Character, Node> childrenMap;
        private String key;
        private boolean isTerminal;

        private Node(char c) {
            this.c = c;
            this.isTerminal = false;
        }

        private boolean addChild(Node node) {
            if (childrenMap == null) {
                childrenMap = new HashMap<>();
            } else if (childrenMap.containsKey(node.c)) {
                return false;
            }
            childrenMap.put(node.c, node);
            return true;
        }

        private Node getChild(char c) {
            return childrenMap == null ? null : childrenMap.get(c);
        }
    }

    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public boolean put(String s) {
        boolean inserted = false;
        Node prev = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node curr;
            if ((curr = prev.getChild(c)) == null) {
                curr = new Node(c);
                prev.addChild(curr);
                inserted = true;
            }
            prev = curr;
        }
        prev.isTerminal = true;
        prev.key = s;
        return inserted;
    }

    public boolean contains(String s) {
        Node prev = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node curr;
            if ((curr = prev.getChild(c)) == null) {
                return false;
            }
            prev = curr;
        }
        return prev.isTerminal;
    }

    public List<String> kDiff(String s, int k) {
        class TNode {
            Node node;
            int idx;
            int miss;

            private TNode(Node n, int i, int m) {
                node = n;
                idx = i;
                miss = m;
            }
        }
        List<String> list = new ArrayList<>();
        Deque<TNode> stack = new ArrayDeque<>();
        stack.push(new TNode(root, 0, 0));
        while (!stack.isEmpty()) {
            TNode curr = stack.pop();
            if (curr.node.isTerminal) {
                list.add(curr.node.key);
                continue;
            }
            if (curr.node.getChild(s.charAt(curr.idx)) == null) {
                curr.miss++;
                if (curr.miss > k) continue;
                for (Map.Entry<Character, Node> entry : curr.node.childrenMap.entrySet()) {
                    stack.push(new TNode(entry.getValue(), curr.idx + 1, curr.miss));
                }
            } else {
                Node child = curr.node.getChild(s.charAt(curr.idx));
                stack.push(new TNode(child, curr.idx + 1, curr.miss));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] a = {"king", "kunal", "soccer", "shimano"};
        Trie trie = new Trie();
        for (String s : a) trie.put(s);
        System.err.println(trie.contains("shimano"));
        System.err.println(trie.contains("shim"));

        String[] b = {"baca", "banaba", "banaca", "banacc"};
        trie = new Trie();
        for (String s : b) trie.put(s);
        List<String> list = trie.kDiff("banana", 1);
        for (String s : list) System.err.println(s);
    }
}
