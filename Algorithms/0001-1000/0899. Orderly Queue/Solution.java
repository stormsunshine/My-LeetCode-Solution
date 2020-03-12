class Solution {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            String smallest = S;
            int length = S.length();
            for (int i = 1; i < length; i++) {
                String str1 = S.substring(0, i);
                String str2 = S.substring(i);
                String newStr = str2 + str1;
                if (newStr.compareTo(smallest) < 0)
                    smallest = newStr;
            }
            return smallest;
        } else {
            char[] array = S.toCharArray();
            Arrays.sort(array);
            return new String(array);
        }
    }
}