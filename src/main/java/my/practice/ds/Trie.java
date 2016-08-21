package my.practice.ds;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kmishra on 8/17/2016.
 */
public class Trie {

    public static class Node {
        private char c;
        private Map<Character, Node> childrenMap;
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

    public static void main(String[] args) {
        String[] a = {"king", "kunal", "soccer", "shimano"};
        Trie trie = new Trie();
        for (String s : a) trie.put(s);
        System.err.println(trie.contains("shimano"));
        System.err.println(trie.contains("shim"));
    }
}
