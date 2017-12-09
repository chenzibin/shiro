package trie;

public class Trie {

    private String[] dict = {"antd", "book", "java", "redis", "python", "zookeeper"};

    private TrieNode root;

    public void build() {
        root = new TrieNode();
        root.setLetter("");
        root.setContent("根节点");

        for (String word : dict) {
            word = word.trim();
            if (word.length() > 0) {
                buildNode(word);
            }

        }
    }

    private void buildNode(String word) {
        TrieNode node = new TrieNode();
        node.setLetter(word.substring(0, 1));

    }

    public static void main(String[] args) {

    }
}
