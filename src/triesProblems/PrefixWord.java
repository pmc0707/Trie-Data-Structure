package triesProblems;

public class PrefixWord {
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();

            } else {
                curr.children[index].freq++;
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public static void findPrefix(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"zebra", "apple", "dog", "duck", "dove"};
        for (String word : words) {
            insert(word);
        }
        root.freq = -1;
        findPrefix(root, "");
    }

    static class Node {
        public int freq;
        Node[] children = new Node[26];
        boolean isWord = false;

        public Node() {
            for (int i=0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
}

