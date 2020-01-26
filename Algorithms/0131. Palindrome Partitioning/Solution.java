class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partition = new ArrayList<List<String>>();
        if (s.length() == 0) {
            partition.add(new ArrayList<String>());
            return partition;
        }
        if (s.length() == 1) {
            List<String> strList = new ArrayList<String>();
            strList.add(s);
            partition.add(strList);
            return partition;
        }
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String substr = s.substring(0, i);
            if (isPalindrome(substr)) {
                if (i == length) {
                    List<String> strList = new ArrayList<String>();
                    strList.add(s);
                    partition.add(strList);
                } else {
                    List<List<String>> subPartition = partition(s.substring(i));
                    for (List<String> list : subPartition) {
                        List<String> newList = new ArrayList<String>();
                        newList.add(substr);
                        newList.addAll(list);
                        partition.add(newList);
                    }
                }
            }
        }
        return partition;
    }

    public boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;
        int low = 0, high = str.length() - 1;
        while (low < high) {
            char c1 = str.charAt(low);
            char c2 = str.charAt(high);
            if (c1 != c2)
                return false;
            low++;
            high--;
        }
        return true;
    }
}