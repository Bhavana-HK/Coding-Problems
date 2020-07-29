// https://leetcode.com/problems/add-and-search-word-data-structure-design/

class WordDictionary {
    public class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }
    
    private TrieNode root = new TrieNode();
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[] word, int k, TrieNode node){
        if(k == word.length)
            return node.isWord;
        if(word[k] == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null && match(word, k+1, node.children[i]))
                    return true;
            }
            return false;
        }
        else
            return node.children[word[k] - 'a'] != null 
                && match(word, k+1, node.children[word[k] - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */