package triesProblems;

public class StartWith {
    public static Node root = new Node();

    public static void insert(String word) {
        int level =0;
        int len = word.length();
        int index = 0;
        Node curr = root;
        for (;level<len;level++) {
             index = word.charAt(level) - 'a';
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
    public static boolean startsWith(String prefix ) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }


    public static void main(String[] args) {
       String [] words = {"apple", "mango", "man", "woman"};
       String prefix = "apple";
       String prefix2 = "mango";

       for (int i = 0; i < words.length; i++) {
           insert(words[i]);
       }
       System.out.println(startsWith(prefix));
       System.out.println(startsWith(prefix2));
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isWord ;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
        }
    }
}

