class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                if (node.children[bit] == null)
                    node.children[bit] = new TrieNode();
                node = node.children[bit];
                node.min = Math.min(node.min, num);
            }
            node.isEnd = true;
        }
        int queriesCount = queries.length;
        int[] maxXors = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            int xor = 0;
            int[] query = queries[i];
            int x = query[0], m = query[1];
            TrieNode node = root;
            boolean flag = true;
            for (int j = 31; j >= 0; j--) {
                int bit = (x & (1 << j)) == 0 ? 1 : 0;
                if (node.children[bit] != null && node.children[bit].min <= m) {
                    if (bit == 1)
                        xor ^= 1 << j;
                    node = node.children[bit];
                } else if (node.children[1 - bit] != null && node.children[1 - bit].min <= m) {
                    if (bit == 0)
                        xor ^= 1 << j;
                    node = node.children[1 - bit];
                } else {
                    flag = false;
                    break;
                }
            }
            if (node.isEnd && flag)
                maxXors[i] = xor ^ x;
            else
                maxXors[i] = -1;
        }
        return maxXors;
    }
}

class TrieNode {
    int min = Integer.MAX_VALUE;
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
        isEnd = false;
    }
}