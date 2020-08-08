class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        int length = s.length();
        int[] differences = new int[length];
        for (int i = 0; i < length; i++) {
            int difference = t.charAt(i) - s.charAt(i);
            if (difference < 0)
                difference += 26;
            differences[i] = difference;
        }
        Arrays.sort(differences);
        int index = 0;
        while (index < length && differences[index] == 0)
            index++;
        if (index == length)
            return true;
        int prev = differences[index];
        index++;
        while (index < length) {
            if (differences[index] == prev)
                differences[index] = differences[index - 1] + 26;
            else
                prev = differences[index];
            if (differences[index] > k)
                return false;
            index++;
        }
        return true;
    }
}