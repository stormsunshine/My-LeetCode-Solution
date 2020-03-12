class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if (str1.length() != str2.length())
                    return str2.length() - str1.length();
                else
                    return str1.compareTo(str2);
            }
        });
        Map<String, Integer> map = new HashMap<String, Integer>();
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            int count = map.getOrDefault(str, 0);
            count++;
            map.put(str, count);
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            boolean isLUS = true;
            if (map.get(str) == 1) {
                for (String prevStr : set) {
                    if (isSubsequence(str, prevStr)) {
                        isLUS = false;
                        break;
                    }
                }
                if (isLUS)
                    return str.length();
            }
            set.add(str);
        }
        return -1;
    }

    public boolean isSubsequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        int index1 = 0;
        for (int index2 = 0; index1 < length1 && index2 < length2; index2++) {
            if (str1.charAt(index1) == str2.charAt(index2))
                index1++;
        }
        return index1 == length1;
    }
}