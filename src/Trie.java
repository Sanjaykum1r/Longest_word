import java.util.LinkedList;
import java.util.List;
public class Trie {


    private final TrieNode root;
    private TrieNode current;

    public Trie() {
        root = new TrieNode(' ');
        current = root;
    }

    public void insert(String value) {
        char letter;
        current= root;
        for (int index = 0; index < value.length(); index++) {
            letter = value.charAt(index);
            if (!current.containsChild(letter)) {
                current.addChild(letter);
            }
            current = current.getChild(letter);
        }
        current.setWord(true);
    }

    public List<Integer> getSuffixStartIndices(String value) {
        List<Integer> indices = new LinkedList<>();
        char letter;
        current = root;
        for (int index = 0; index < value.length(); index++) {
            letter = value.charAt(index);
            if (!current.containsChild(letter))
                return indices;
            current = current.getChild(letter);
            if (current.isWord())
                indices.add(index + 1);
        }
        return indices;
    }

}