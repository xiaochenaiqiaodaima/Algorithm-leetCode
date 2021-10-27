package 添加与搜索单词_数据结构设计.官方解答;

import java.util.Arrays;

class WordDictionary {
    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(Trie root,String word) {
        root.insert(root,word);
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord(wordDictionary.root,"bad");
        System.out.println(wordDictionary.root.toString());
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
        boolean bad = wordDictionary.search("bad");
        System.out.println(bad);
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "children=" + Arrays.toString(children) +
                ", isEnd=" + isEnd +
                '}';
    }

    public void insert(Trie node,String word) {
//        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
