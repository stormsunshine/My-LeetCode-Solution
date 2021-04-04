class Solution {
    public String truncateSentence(String s, int k) {
        String[] array = s.split(" ");
        StringBuffer sb = new StringBuffer(array[0]);
        for (int i = 1; i < k; i++)
            sb.append(" " + array[i]);
        return sb.toString();
    }
}