/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

*/

class Trie {
    TrieNode root;
    public Trie() {
      root = new TrieNode('\0');  
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++)
        {
            char current = word.charAt(i);
            if(curr.children[current-'a'] == null) curr.children[current-'a'] = new TrieNode(current);
            curr = curr.children[current-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node!=null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = getNode(prefix);
        return node!=null;
    }
    
    public TrieNode getNode(String word)
    {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++)
        {
            char current = word.charAt(i);
            if(curr.children[current-'a'] == null) return null;
            curr = curr.children[current-'a'];
        }
        return curr;
    }
    
    class TrieNode {
        public TrieNode[] children;
        public boolean isWord;
        public char c;
        public TrieNode(char ch)
        {
            children = new TrieNode[26];
            c = ch;
            isWord = false;
        }
    }
}
