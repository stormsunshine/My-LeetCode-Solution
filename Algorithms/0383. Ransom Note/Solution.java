class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] ransomNoteArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        for (char c : ransomNoteArray)
            count1[c - 'a']++;
        for (char c : magazineArray)
            count2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (count1[i] > count2[i])
                return false;
        }
        return true;
    }
}