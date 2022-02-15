import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class LongestWord {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc=new Scanner(System.in);
        String inputFileName=sc.next();
        File input = new File(inputFileName).getAbsoluteFile();
        sc.close();

        Trie trie = new Trie();
        LinkedList<Pair<String>> queue = new LinkedList<>();
        Set<String> compoundWords = new HashSet<>();

        @SuppressWarnings("resource")
        Scanner scanner_input = new Scanner(input);

        String word;
        List<Integer> sufIndices;

        long startTime = System.currentTimeMillis();
        while (scanner_input.hasNext()) {
            word = scanner_input.next();
            sufIndices = trie.getSuffixStartIndices(word);

            for (int index : sufIndices) {
                if (index >= word.length())
                    break;
                queue.add(new Pair<>(word, word.substring(index)));
            }

            trie.insert(word);
        }

        scanner_input.close();
        findTheLongestAndSecondLongestWord(trie, queue,compoundWords);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime-startTime;
        System.out.println("Time taken to process the input file is : "+ timeTaken+"ms");
    }

    private static void findTheLongestAndSecondLongestWord(Trie trie, LinkedList<Pair<String>> queue,
                                                           Set<String> compoundWords){

        Pair<String> stringPair;
        int maxLength = 0;
        String longestWord = "";
        String secondLongestWord = "";

        while (!queue.isEmpty()) {
            stringPair = queue.removeFirst();
            String word = stringPair.getSecond();

            List<Integer> sufIndices = trie.getSuffixStartIndices(word);
            if (sufIndices.isEmpty()) {
                continue;
            }
            for (int index : sufIndices) {
                if (index > word.length()) {
                    break;
                }

                if (index == word.length()) {
                    if (stringPair.getFirst().length() > maxLength) {
                        secondLongestWord = longestWord;
                        maxLength = stringPair.getFirst().length();
                        longestWord = stringPair.getFirst();
                    }

                    compoundWords.add(stringPair.getFirst());

                } else {
                    queue.add(new Pair<>(stringPair.getFirst(), word.substring(index)));
                }
            }
        }
        System.out.println("Longest Compound Word: " + longestWord);
        System.out.println("Second Longest Compound Word: " + secondLongestWord);
    }
}