class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        char[] array = text.toCharArray();
        for (char c : array)
            count[c - 'a']++;
        int max = Integer.MAX_VALUE;
        max = Math.min(max, count['b' - 'a']);
        max = Math.min(max, count['a' - 'a']);
        max = Math.min(max, count['l' - 'a'] / 2);
        max = Math.min(max, count['o' - 'a'] / 2);
        max = Math.min(max, count['n' - 'a']);
        return max;
    }
}