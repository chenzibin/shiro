package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private String letter;

    private String content;

    private Map<String, TrieNode> childNodes;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, TrieNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<String, TrieNode> childNodes) {
        this.childNodes = childNodes;
    }

    public void setChildNode(String key, TrieNode node) {
        if (childNodes == null) {
            childNodes = new HashMap<>();
        }
        childNodes.put(key, node);
    }

    public TrieNode getChildNode(String key) {
        if (childNodes == null) {
            return null;
        }
        return childNodes.get(key);
    }
}
