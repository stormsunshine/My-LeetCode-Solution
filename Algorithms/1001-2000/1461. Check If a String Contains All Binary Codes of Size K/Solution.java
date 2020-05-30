class Solution {
    public boolean hasAllCodes(String s, int k) {
        int length = s.length();
        int counts = (int) Math.pow(2, k);
        if (length - k + 1 < counts)
            return false;
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++)
            sb.append(s.charAt(i));
        set.add(sb.toString());
        for (int i = k; i < length; i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            set.add(sb.toString());
        }
        return set.size() == counts;
    }
}