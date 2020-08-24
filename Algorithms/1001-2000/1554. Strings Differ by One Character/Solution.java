class Solution {
    public boolean differByOne(String[] dict) {
        int length = dict.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (differByOne(dict[i], dict[j]))
                    return true;
            }
        }
        return false;
    }

    public boolean differByOne(String str1, String str2) {
        int difference = 0;
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                difference++;
        }
        return difference == 1;
    }
}