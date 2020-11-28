class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxRepeating = 0;
        StringBuffer sb = new StringBuffer();
        int k = 0;
        while (sb.length() <= sequence.length()) {
            sb.append(word);
            k++;
            if (sequence.indexOf(sb.toString()) >= 0)
                maxRepeating = k;
        }
        return maxRepeating;
    }
}