class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> camelMatchList = new ArrayList<Boolean>();
        int length = queries.length;
        for (int i = 0; i < length; i++) {
            String query = queries[i];
            camelMatchList.add(isSubsequenceAndCamelcase(pattern, query));
        }
        return camelMatchList;
    }

    public boolean isSubsequenceAndCamelcase(String pattern, String query) {
        int length1 = pattern.length(), length2 = query.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            char c1 = pattern.charAt(index1), c2 = query.charAt(index2);
            index2++;
            if (c1 == c2)
                index1++;
            else {
                if (c2 <= 'Z')
                    return false;
            }
        }
        while (index2 < length2) {
            char c2 = query.charAt(index2);
            index2++;
            if (c2 <= 'Z')
                return false;
        }
        return index1 == length1;
    }
}