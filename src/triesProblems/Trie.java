package triesProblems;

public class Trie {
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();

            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;

            }
            curr = curr.children[index];
        }
        return curr.isWord = true;
    }

    public static void main(String[] args) {
        String[] words = {"the", "a", "their", "any"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(search("thee"));
        System.out.println(search("the"));

    }

    static class Node {
        Node[] children = new Node[26];
        boolean isWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
        }
    }
}
