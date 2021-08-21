class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        char prev = 'a';
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char curr = word.charAt(i);
            int difference = Math.abs(curr - prev);
            difference = Math.min(difference, 26 - difference);
            time += difference + 1;
            prev = curr;
        }
        return time;
    }
}