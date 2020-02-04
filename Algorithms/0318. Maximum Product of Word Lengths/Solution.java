class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] mask = new int[length];
        for (int i = 0; i < length; i++)
            mask[i] = getMask(words[i]);
        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((mask[i] & mask[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }
        return maxProduct;
    }

    public int getMask(String word) {
        int mask = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            mask |= 1 << c - 'a';
        }
        return mask;
    }
}