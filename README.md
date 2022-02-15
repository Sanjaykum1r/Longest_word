### Longest Compound Word Finder

## The problem 

- A sequence of dictionary words, one per line, is fed to your program's standard input. Find the longest compound word in this list. That is find
the longest word in this list that is a concatenation of two or more word also in this list. A word's length is equal to
its number of characters.


## My Solution
- For this solution I have Created four classes.
  - LongestWord.
  - Trie.
  - TrieNode.
  - Pair.

- In LongestWord class I take input as InputFileName and 




- In Trie class define TrieNode variable root and current.
  - After that I have created two method first is Insert method and second is getSuffixStartIndices
  - In Insert method check root value string from null string. After that insert char one by one in the TrieNode.
  - In getSuffixStartIndices method check TrieNode contains word or not. If contains increment index


- In TrieNode class I have created multiple method like isWord, setWord, addChild, getChild, containsChild.

- In Pair class I have declared two variable first and second String variable. And create two method to get the first string and second string from the inputFile.





## How to run?

- Give fileName as input.
- And the output is: 
- Longest Compound Word: ratcatdogcat.
- Second Longest Compound Word: catsdogcats.
- Time taken to process the input file is : 37ms.
- 
 
