class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        TreeSet<String> contacts = new TreeSet<>();
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Build the Trie
        TrieNode root = new TrieNode();
        for (String name : contact) {
            insertIntoTrie(root, name);
        }

        // Search for each prefix of s
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        TrieNode current = root;

        for (char c : s.toCharArray()) {
            if (current != null && current.children.containsKey(c)) {
                current = current.children.get(c);
                result.add(new ArrayList<>(current.contacts));
            } else {
                // No matches for this prefix
                current = null;
                result.add(new ArrayList<>(Collections.singletonList("0")));
            }
        }

        return result;
    }

    private static void insertIntoTrie(TrieNode root, String name) {
        TrieNode current = root;
        for (char c : name.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
            current.contacts.add(name);
        }
    }
}
