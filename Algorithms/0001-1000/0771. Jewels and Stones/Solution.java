class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        int jewels = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int index = J.indexOf(c);
            if (index >= 0)
                jewels++;
        }
        return jewels;
    }
}