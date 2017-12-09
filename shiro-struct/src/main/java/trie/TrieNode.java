package trie;

import java.util.Map;

public class TrieNode {

    private String letter;

    private String content;

    private Map<String, TrieNode> nextNode;

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

    public Map<String, TrieNode> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Map<String, TrieNode> nextNode) {
        this.nextNode = nextNode;
    }
}
