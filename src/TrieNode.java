import java.util.HashMap;

public class TrieNode {
    @SuppressWarnings("unused")
    private char val;
    private final HashMap<Character, TrieNode> children;
    private boolean isWord;

    public boolean isWord() {
        return isWord;
    }
    public void setWord(boolean word) {
        isWord = word;
    }
    public TrieNode(char val) {
        this.val = val;
        children = new HashMap<>();
        isWord = false;
    }
    public void addChild(char child) {
        children.put(child, new TrieNode(child));
    }
    public TrieNode getChild(char child) {
        if (!children.containsKey(child)) {
            return null;
        }
        return children.get(child);
    }
    public boolean containsChild(char child) {
        return children.containsKey(child);
    }
}