package leetcode;
//Implement a trie with insert, search, and startsWith methods.
import java.util.ArrayList;
import java.util.HashMap;
class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isLeaf=false;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode() {
    	
    }
    public TrieNode(char x) {
    	this.val=x;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode node=root;
    	int i=0;
        for(;i<word.length();i++){
            if(node.children.containsKey(word.charAt(i))){
            	node=node.children.get(word.charAt(i));
            	continue;
            }else{
            	TrieNode nextnode=new TrieNode(word.charAt(i));
            	node.children.put(word.charAt(i),nextnode);
            	node=nextnode;
            }
        }
        node.isLeaf=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode node=root;
    	int i=0;
        for(;i<word.length();i++){
        	node=node.children.get(word.charAt(i));
            if(node==null)
            	break;
        }
        if(i==word.length() && node.isLeaf==true)
        	return true;
        else
        	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node=root;
    	int i=0;
    	for(;i<prefix.length();i++){
    		node=node.children.get(prefix.charAt(i));
            if(node==null)
            	break;
        }
        if(i==prefix.length())
        	return true;
        else
        	return false;
    }
    public static void main(String[] args){
    	Trie trie=new Trie();
    	trie.insert("wordisa");
    	System.out.print(trie.search("wordisa"));
    	System.out.print(trie.startsWith("word"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
