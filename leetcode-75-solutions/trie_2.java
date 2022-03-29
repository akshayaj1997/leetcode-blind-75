/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

*/

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++)
        {
            char current = word.charAt(i);
            if(curr.children[current - 'a'] == null) curr.children[current-'a'] = new TrieNode(current);
            curr = curr.children[current-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return getNode(word, root);
    }
    public boolean getNode(String word, TrieNode curr)
    {
        TrieNode c = curr;
        for(int i=0; i < word.length(); i++)
        {
            char current = word.charAt(i);
            if(current == '.')
            {
                for(TrieNode child: c.children)
                    if(child!= null && getNode(word.substring(i+1),  child)) return true;
                return false;
            }
            if(c.children[current - 'a'] == null) return false;
            else c = c.children[current-'a'];
        }
        return c.isWord;
    }
    class TrieNode {
        public TrieNode[] children;
        public boolean isWord;
        public char ch;
        public TrieNode(char c)
        {
            children = new TrieNode[26];
            isWord = false;
            ch = c;
        }
    } 
}
