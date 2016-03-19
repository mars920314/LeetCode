package ArrayMap;
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class AddandSearchWord {
	TrieNode root=new TrieNode('a');
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word==null)
        	return;
        TrieNode current=root;
        for(int i=0; i<word.length(); i++){
        	if(!current.children.containsKey(word.charAt(i))){
        		TrieNode child=new TrieNode(word.charAt(i));
        		current.children.put(word.charAt(i), child);
        		current=child;
        	}else{
        		current=current.children.get(word.charAt(i));
        	}
        }
        current.isleaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search1(String word) {
        if(word==null)
        	return true;
        TrieNode current=root;
        for(int i=0;i<word.length();i++){
        	if(!current.children.containsKey(word.charAt(i)))
        		return false;
        	else
        		current=current.children.get(word.charAt(i));
        }
        return true;
    }

    public boolean search(String word) {
    	if(word==null)
        	return true;
    	return searchhelper(word, root);
    }
    boolean searchhelper(String word, TrieNode children){
        TrieNode current=children;
        for(int i=0; i<word.length();i++){
        	if(word.charAt(i)=='.'){
        		Iterator ite=current.children.entrySet().iterator();
        		while(ite.hasNext()){
        			Map.Entry<Character, TrieNode> entry=(Map.Entry) ite.next();
        			if(searchhelper(word.substring(i+1,word.length()), entry.getValue()))
        				return true;
        			else if(i==word.length()-1 && entry.getValue().isleaf)
        				return true;
        		}
        		return false;
        	}
        	if(!current.children.containsKey(word.charAt(i)))
        		return false;
        	else
        		current=current.children.get(word.charAt(i));
        }
        return current.isleaf;
    }
    public static void main(String[] args){
    	AddandSearchWord ASW=new AddandSearchWord();
    	ASW.addWord("word");
    	System.out.println(ASW.search("word"));
    	System.out.println(ASW.search("word."));
    }
}
class TrieNode{
	char val;
	boolean isleaf=false;
	HashMap<Character, TrieNode> children=new HashMap<Character, TrieNode>();
	TrieNode(char x){
		this.val=x;
	}
}
