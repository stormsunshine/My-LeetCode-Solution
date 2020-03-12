class Solution {
    public int calculateTime(String keyboard, String word) {
        int time = 0;
        int index = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int curIndex = keyboard.indexOf(c);
            time += Math.abs(curIndex - index);
            index = curIndex;
        }
        return time;
    }
}