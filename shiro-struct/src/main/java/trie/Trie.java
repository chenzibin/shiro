package trie;

public class Trie {

    private String[] dict = {"antd", "book", "java", "redis", "python", "zookeeper"};

    private TrieNode root;

    public void build() {
        root = new TrieNode();
        root.setLetter("");
        root.setContent("根节点");

        for (String word : dict) {
            buildNode(word);
        }
    }

    private void buildNode(String word) {
        word = word.trim();
        if (word.length() > 0) {
            buildNode(word, root);
        }
    }

    private void buildNode(String word, TrieNode parent) {
        String[] split = word.split("", 2);
        final String prefix = split[0];


        TrieNode node = new TrieNode();
        node.setLetter(prefix);
        parent.setChildNode(prefix, node);
        if (word.length() > 1) {
            buildNode(split[1], node);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.build();

        trie.buildNode("sql");

        System.out.println(trie);
    }
}
