package triesProblems;

public class WordBreak {
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

    public static boolean wordBreak(String key) {
        if (key.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        String[] words = {"i", "like", "mango", "and", "apple"};
        for (String word : words) {
            insert(word);
        }
        String key = "apple";
        System.out.println(wordBreak(key));
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
